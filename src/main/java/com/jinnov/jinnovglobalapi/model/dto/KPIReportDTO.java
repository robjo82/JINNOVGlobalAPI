package com.jinnov.jinnovglobalapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
        requiredProperties = {"date", "value"},
        description = "Object describing a KPI report"
)
public class KPIReportDTO {
    @Schema(
            description = "The date of the report",
            example = "2023-11-18"
    )
    private String date;

    @Schema(
            description = "The value of the report",
            example = "20 000"
    )
    private String value;
}
