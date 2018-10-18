package com.springsecurityexample.model;

public enum TokenTypeEnum {
    BEARER("Bearer");

    private String value;

    TokenTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
