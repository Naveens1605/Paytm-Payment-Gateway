package com.tiffytaste.paytmpaymentgateway.model;

import org.springframework.stereotype.Component;

@Component
public class PaymentRequest {

    private Body body;
    private Head head;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }
}
