package com.tiffytaste.paytmpaymentgateway.model;

import org.springframework.stereotype.Component;

@Component
public class Head {

    private String signature;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
