package com.jinnov.jinnovglobalapi.model;

import com.google.cloud.firestore.annotation.DocumentId;

public abstract class BaseEntity {
    @DocumentId
    private String id;

    private String dataCreator;
}
