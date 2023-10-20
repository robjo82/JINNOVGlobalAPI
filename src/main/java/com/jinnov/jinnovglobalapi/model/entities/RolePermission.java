package com.jinnov.jinnovglobalapi.model.entities;

public class RolePermission {
    private Role role;
    private String table;
    private Integer create; // integer between 0 and 3 representing the level of permission
    private Integer read;
    private Integer update;
    private Integer delete;
}
