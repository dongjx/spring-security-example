package com.springsecurityexample.model;

public enum RoleNameEnum {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private String value;

    RoleNameEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
