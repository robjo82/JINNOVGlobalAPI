package com.jinnov.jinnovglobalapi.model.entities;

import com.google.cloud.Timestamp;
import com.jinnov.jinnovglobalapi.model.BaseEntity;

public class TemporaryPermission extends BaseEntity {
    private String table;
    private Integer create; // integer between 0 and 3 representing the level of permission
    private Integer read;
    private Integer update;
    private Integer delete;
    private Timestamp endDate;
}
