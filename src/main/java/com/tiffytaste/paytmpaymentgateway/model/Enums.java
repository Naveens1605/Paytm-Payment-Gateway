package com.tiffytaste.paytmpaymentgateway.model;

public enum Enums {
    MERCHANT_KEY("rMxcuPjuOLj3Rg0x"),
    MID("EePDDq56318813172597"),
    REQUEST_TYPE("Payment"),
    WEBSITE("WEBSTAGING"),
    PAYMENT_DEV_URL("https://securegw-stage.paytm.in/theia/api/v1/initiateTransaction?mid=%1$s&orderId=%2$s"),
    PAYMENT_PROD_URL("https://securegw.paytm.in/theia/api/v1/initiateTransaction?mid=%1$s&orderId=%2$s"),
    USER("User");

    private final String value;

    Enums(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
