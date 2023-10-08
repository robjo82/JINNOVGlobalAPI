package com.jinnov.jinnovglobalapi.repository.impl;

import com.jinnov.jinnovglobalapi.repository.IHealthCheckRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class HealthCheckRepositoryImpl implements IHealthCheckRepository {
    public String getPing() {
        return "pong";
    }
}
