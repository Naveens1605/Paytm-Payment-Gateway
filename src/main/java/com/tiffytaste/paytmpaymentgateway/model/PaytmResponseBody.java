package com.tiffytaste.paytmpaymentgateway.model;

public class PaytmResponseBody {

    private PaytmResponseResultInfo resultInfo;
    private String txnToken;
    private boolean isPromoCodeValid;
    private boolean authenticated ;

    public PaytmResponseResultInfo getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(PaytmResponseResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    public String getTxnToken() {
        return txnToken;
    }

    public void setTxnToken(String txnToken) {
        this.txnToken = txnToken;
    }

    public boolean isPromoCodeValid() {
        return isPromoCodeValid;
    }

    public void setPromoCodeValid(boolean promoCodeValid) {
        isPromoCodeValid = promoCodeValid;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
