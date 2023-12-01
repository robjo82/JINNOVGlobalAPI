package com.jinnov.jinnovglobalapi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum KPIBoardsEnum {
    GLOBAL_KPI("4329614614"),
    BUSINESS_UNIT("4591123737"),
    QUALITY("5055895830"),
    COMMUNICATION("5055791084"),
    HUMAN_RESOURCES("4847814554"),
    TREASURY("5055889874");

    private final String id;
}
