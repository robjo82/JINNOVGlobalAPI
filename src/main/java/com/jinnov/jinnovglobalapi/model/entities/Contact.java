package com.jinnov.jinnovglobalapi.model.entities;

import com.google.cloud.Timestamp;
import com.jinnov.jinnovglobalapi.model.BaseEntity;
import com.jinnov.jinnovglobalapi.model.HistoricEntity;
import com.jinnov.jinnovglobalapi.model.enums.ContactType;

import java.util.List;

public class Contact extends BaseEntity {
    private HistoricEntity<String> lastName;
    private HistoricEntity<String> firstName;
    private HistoricEntity<Timestamp> birthDate;
    private HistoricEntity<String> pronoun;
    private HistoricEntity<List<ContactType>> contactTypes;
    private HistoricEntity<String> address;
    private HistoricEntity<String> phoneNumber;
    private HistoricEntity<String> professionalEmail;
    private HistoricEntity<String> personalEmail;
    private HistoricEntity<String> universityEmail;
    private HistoricEntity<String> enterpriseId;
    private HistoricEntity<String> position;
    private HistoricEntity<String> nationality;
    private HistoricEntity<String> VISAorResidencePermitURL;
    private HistoricEntity<String> vitalCardURL;
    private HistoricEntity<String> identityDocumentURL;
    private HistoricEntity<String> schoolCertificateURL;
    private HistoricEntity<String> membershipFormURL;
    private HistoricEntity<String> linkedInURL;
    private HistoricEntity<String> facebookURL;
    private HistoricEntity<String> instagramURL;
    private HistoricEntity<String> trainingId;
    private HistoricEntity<String> profilePicture1024URL;
    private HistoricEntity<String> profilePicture512URL;
    private HistoricEntity<String> profilePicture256URL;
    private HistoricEntity<Boolean> subscribedToNewsletter;
}