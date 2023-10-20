package com.jinnov.jinnovglobalapi.model.entities;

import com.jinnov.jinnovglobalapi.model.BaseEntity;
import com.jinnov.jinnovglobalapi.model.HistoricEntity;

import java.util.List;

public class User extends BaseEntity {
    private HistoricEntity<String> contactId;
    private HistoricEntity<Preference> preferences;
    private HistoricEntity<List<Role>> roles; // To get associated permissions
    private HistoricEntity<List<TemporaryPermission>> temporaryPermissions;
    private HistoricEntity<Boolean> isActivated;

}
