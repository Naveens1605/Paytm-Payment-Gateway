package com.tiffytaste.paytmpaymentgateway.service;

import com.google.gson.Gson;
import com.tiffytaste.paytmpaymentgateway.model.PaymentRequest;
import com.tiffytaste.paytmpaymentgateway.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

      @Autowired Gson gson;

      @Autowired PaymentRepository paymentRepository;

      public String initiateTransaction(PaymentRequest paymentRequest) {
            return paymentRepository.initiateTransaction(paymentRequest);
      }

      public String verifyTransaction() {
            return "";
      }
}
