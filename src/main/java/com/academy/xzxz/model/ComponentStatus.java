package com.academy.xzxz.model;

public enum ComponentStatus {
    ACTIVE ("В производстве"),
    NOT_ACTIVE ("Снят с производства");

    private String status;

    ComponentStatus(String status) {
        this.status = status;
    }
}
