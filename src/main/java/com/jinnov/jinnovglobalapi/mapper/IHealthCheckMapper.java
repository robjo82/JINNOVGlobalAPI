package com.jinnov.jinnovglobalapi.mapper;

import com.jinnov.jinnovglobalapi.model.HealthCheck;
import com.jinnov.jinnovglobalapi.model.dto.HealthCheckDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IHealthCheckMapper {
    @Mapping(target = "status", source = "status")
    @Mapping(target = "message", source = "message")
    HealthCheckDTO healthCheckToHealthCheckDTO(HealthCheck healthCheck);

    @Mapping(target = "status", source = "status")
    @Mapping(target = "message", source = "message")
    HealthCheck healthCheckDTOToHealthCheck(HealthCheckDTO healthCheckDTO);

}
