package com.tiffytaste.paytmpaymentgateway.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tiffytaste.paytmpaymentgateway.model.Body;
import com.tiffytaste.paytmpaymentgateway.model.Head;
import com.tiffytaste.paytmpaymentgateway.model.PaymentRequest;
import com.tiffytaste.paytmpaymentgateway.service.ChecksumGenerateService;
import com.tiffytaste.paytmpaymentgateway.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment", method = RequestMethod.POST)
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    ChecksumGenerateService checksumGenerateService;

    @Autowired
    PaymentRequest paymentRequest;

    @Autowired Head head;

    @Autowired
    Gson gson;

    @PostMapping("/initiate_transaction")
    private ResponseEntity<?> initiateTransaction(@RequestBody Body body) {
        head.setSignature(checksumGenerateService.generateChecksum(body));
        paymentRequest.setHead(head);
        paymentRequest.setBody(body);
        String response = paymentService.initiateTransaction(paymentRequest);
        boolean valid = checksumGenerateService.verifyChecksum(response);
        if(valid ) return ResponseEntity.ok(response);
        else return ResponseEntity.ok("Transaction Token Verification Failed");
    }

    @PostMapping("/verify_transaction")
    private String verifyTransaction() {
        return "Transaction Verified";
    }
}
