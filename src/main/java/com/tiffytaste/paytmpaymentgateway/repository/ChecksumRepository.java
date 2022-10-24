package com.tiffytaste.paytmpaymentgateway.repository;

import com.google.gson.Gson;
import com.paytm.pg.merchant.PaytmChecksum;
import com.tiffytaste.paytmpaymentgateway.model.Body;
import com.tiffytaste.paytmpaymentgateway.model.Enums;
import com.tiffytaste.paytmpaymentgateway.model.PaymentRequest;
import com.tiffytaste.paytmpaymentgateway.model.PaytmResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChecksumRepository {

    @Autowired
    Gson gson;

    public String generateChecksum(Body body) {
        try {
            return PaytmChecksum.generateSignature(gson.toJson(body), Enums.MERCHANT_KEY.getValue());
        } catch (Exception e){
            return e.getLocalizedMessage();
        }
    }

    public boolean verifyChecksum(String response) {
        try {
            return PaytmChecksum.verifySignature(gson.toJson(gson.fromJson(gson.toJson(gson.fromJson(response, PaymentRequest.class).getBody()),PaytmResponseBody.class)), Enums.MERCHANT_KEY.getValue(), gson.fromJson(response,PaymentRequest.class).getHead().getSignature());
        } catch (Exception e) {
            return false;
        }
    }
}
