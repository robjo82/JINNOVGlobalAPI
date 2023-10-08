package com.jinnov.jinnovglobalapi.model.enums;

import lombok.Getter;

@Getter
public enum HealthCheckStatus {
    UP("UP"),
    DOWN("DOWN");

    private final String status;

    HealthCheckStatus(String status) {
        this.status = status;
    }
}
