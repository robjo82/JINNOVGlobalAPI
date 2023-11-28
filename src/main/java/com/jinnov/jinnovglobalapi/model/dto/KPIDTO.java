package com.jinnov.jinnovglobalapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(
        requiredProperties = {"description", "goal", "owner", "reportingFrequency"},
        description = "Object describing a KPI"
)
public class KPIDTO {
    @Schema(
            description = "The name of the KPI",
            example = "Réaliser 40 000 € de CA"
    )
    private String description;

    @Schema(
            description = "The goal of the KPI at the deadline",
            example = "100%"
    )
    private String goal;

    @Schema(
            description = "The deadline of the KPI",
            example = "2024-05-18"
    )
    private String deadline;

    @Schema(
            description = "The advancement of the KPI calculated with the last value and the goal",
            example = "50%",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private String advancement;

    @Schema(
            description = "The last value of the KPI",
            example = "20 000",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private String lastValue;

    @Schema(
            description = "The last update of the KPI",
            example = "2023-10-18",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private String lastUpdate;

    @Schema(
            description = "The date at which the KPI should be updated",
            example = "2023-11-18",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private String nextUpdate;

    @Schema(
            description = "The owner of the KPI",
            example = "Grégoire"
    )
    private String owner;

    @Schema(
            description = "The frequency at which the KPI should be updated, in days",
            example = "14"
    )
    private String reportingFrequency;

    @Schema(
            description = "The history of the KPI",
            example = "[{\"date\": \"2023-10-18\", \"value\": \"20 000\"}, {\"date\": \"2023-10-04\", \"value\": \"15 000\"}]",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private List<KPIReportDTO> history;

}
