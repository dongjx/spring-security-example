package com.springsecurityexample.api.dto;

import com.springsecurityexample.model.TokenTypeEnum;

public class AuthenticationTokenResponse {
    private String accessToken;

    private String tokenType;

    public AuthenticationTokenResponse(String accessToken) {
        this.tokenType = TokenTypeEnum.BEARER.getValue();
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
