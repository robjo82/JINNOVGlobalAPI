package com.jinnov.jinnovglobalapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class HealthCheckDTO {
    private String status;
    private String message;
}
