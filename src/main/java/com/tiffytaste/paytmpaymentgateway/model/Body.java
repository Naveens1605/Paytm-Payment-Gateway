package com.tiffytaste.paytmpaymentgateway.model;

public class Body extends PaytmResponseBody {

    private final String requestType = Enums.REQUEST_TYPE.getValue();
    private final String mid = Enums.MID.getValue();
    private final String websiteName = Enums.WEBSITE.getValue();
    private String orderId;
    private TransactionAmount txnAmount;
    private User userInfo;

    public String getRequestType() {
        return requestType;
    }

    public String getMid() {
        return mid;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public TransactionAmount getTxnAmount() {
        return txnAmount;
    }

    public void setTxnAmount(TransactionAmount txnAmount) {
        this.txnAmount = txnAmount;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }

}