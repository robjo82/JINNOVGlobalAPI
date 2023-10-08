package com.jinnov.jinnovglobalapi.controller;

import com.jinnov.jinnovglobalapi.mapper.IHealthCheckMapperImpl;
import com.jinnov.jinnovglobalapi.model.dto.HealthCheckDTO;
import com.jinnov.jinnovglobalapi.service.HealthCheckService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class HealthCheckController {
    private final IHealthCheckMapperImpl healthCheckMapper;
    private final HealthCheckService healthCheckService;
    @GetMapping("/ping")
    @Operation(summary = "Ping the API")
    public ResponseEntity<HealthCheckDTO> ping() {
        return new ResponseEntity<>(healthCheckMapper.healthCheckToHealthCheckDTO(healthCheckService.ping()), HttpStatus.OK);
    }
}
