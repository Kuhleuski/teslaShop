package com.academy.xzxz.model;

public enum CarStatus {
    ACTIVE ("В производстве"),
    NOT_ACTIVE ("Снят с производства");

    private final String status;

    CarStatus(String status) {
        this.status = status;
    }
}

