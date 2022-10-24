package com.tiffytaste.paytmpaymentgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class PaytmPaymentGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaytmPaymentGatewayApplication.class, args);
    }
}
