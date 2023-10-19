package com.jinnov.jinnovglobalapi.model.entities;

import com.jinnov.jinnovglobalapi.model.BaseEntity;
import com.jinnov.jinnovglobalapi.model.enums.LicenseType;

public class Resource extends BaseEntity {
    private String name;
    private Boolean isEquipment;
    private Boolean isSoftware;
    private Integer annualCost;
    private LicenseType licenseType;
}
