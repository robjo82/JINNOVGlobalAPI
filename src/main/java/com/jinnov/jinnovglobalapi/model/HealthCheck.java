package com.jinnov.jinnovglobalapi.model;

import com.jinnov.jinnovglobalapi.model.enums.HealthCheckStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class HealthCheck {
    private HealthCheckStatus status;
    private String message;
}
