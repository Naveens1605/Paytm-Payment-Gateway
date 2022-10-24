package com.tiffytaste.paytmpaymentgateway.model;

public class TransactionAmount {

    private String value;
    private final String currency = "INR";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }
}
