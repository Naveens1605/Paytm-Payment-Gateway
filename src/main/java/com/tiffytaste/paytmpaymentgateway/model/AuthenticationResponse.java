package com.tiffytaste.paytmpaymentgateway.model;

public class AuthenticationResponse {

    private String userId;
    private String userName;
    private String auth_token;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }

    public String getUserName() {
        return userName;
    }

    public String getAuth_token() {
        return auth_token;
    }
}
