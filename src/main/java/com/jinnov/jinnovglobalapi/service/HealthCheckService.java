package com.jinnov.jinnovglobalapi.service;

import com.jinnov.jinnovglobalapi.model.HealthCheck;
import com.jinnov.jinnovglobalapi.model.enums.HealthCheckStatus;
import com.jinnov.jinnovglobalapi.repository.IHealthCheckRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class HealthCheckService {

    private final IHealthCheckRepository healthCheckRepository;
    public HealthCheck ping() {
        return new HealthCheck(HealthCheckStatus.UP, healthCheckRepository.getPing());
    }
}
