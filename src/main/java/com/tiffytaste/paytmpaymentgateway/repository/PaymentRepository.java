package com.tiffytaste.paytmpaymentgateway.repository;

import com.google.gson.Gson;
import com.tiffytaste.paytmpaymentgateway.model.Enums;
import com.tiffytaste.paytmpaymentgateway.model.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Repository
public class PaymentRepository {

    @Autowired
    Gson gson;

    public String initiateTransaction(PaymentRequest paymentRequest) {
        try {
            URL url = new URL(String.format(Enums.PAYMENT_DEV_URL.getValue(),Enums.MID.getValue(),paymentRequest.getBody().getOrderId()));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            DataOutputStream requestWriter = new DataOutputStream(connection.getOutputStream());
            requestWriter.writeBytes(gson.toJson(paymentRequest));
            requestWriter.close();
            String responseData;
            InputStream is = connection.getInputStream();
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(is));
            if ((responseData = responseReader.readLine()) != null) {
                return responseData;
            }
            responseReader.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "Transaction Token Generation Failed";
    }

    public String verifyTransaction(PaymentRequest paymentRequest) {
        return "";
    }
}
