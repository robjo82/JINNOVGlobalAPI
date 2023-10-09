package com.jinnov.jinnovglobalapi.model.entities;

import com.google.cloud.Timestamp;
import com.jinnov.jinnovglobalapi.model.BaseEntity;
import com.jinnov.jinnovglobalapi.model.enums.DocumentStatus;
import com.jinnov.jinnovglobalapi.model.enums.DocumentType;

import java.util.List;


public class Document extends BaseEntity {
    private String reference; // [Document acronym] - [Year] - [client acronym] - [study number with this client].[version number] ex: "CE-2023-SON-4.2"
    private DocumentType documentType;
    private DocumentStatus documentStatus;
    private Integer version;
    private String url;
    private Timestamp signatureDate;
    private Timestamp expirationDate;
    private List<String> signatoriesIds; // list of user which will have to sign the document, set president by default

}
