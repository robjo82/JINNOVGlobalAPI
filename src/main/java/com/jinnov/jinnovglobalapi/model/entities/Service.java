package com.jinnov.jinnovglobalapi.model.entities;

import com.google.cloud.Timestamp;
import com.jinnov.jinnovglobalapi.model.BaseEntity;
import com.jinnov.jinnovglobalapi.model.HistoricEntity;
import com.jinnov.jinnovglobalapi.model.enums.ServiceStatus;
import org.springframework.context.HierarchicalMessageSource;

import java.util.List;

public class Service extends BaseEntity {
    private HistoricEntity<String> name;
    private HistoricEntity<Offer> offer;
    private HistoricEntity<Timestamp> startDate;
    private HistoricEntity<Timestamp> endDate;
    private HistoricEntity<ServiceStatus> status;
    private HistoricEntity<List<String>> courseId;
    private HistoricEntity<Boolean> isCommunicated; // As incoming requests for new services can be accepted and re-assessed, it is necessary to distinguish between the services that have been communicated to the customer and those that have not (prospecting, website, etc.)
    private HistoricEntity<List<Clientele>> clientele;
    private HistoricEntity<List<Resource>> resources;
    private HistoricEntity<List<SalesPitch>> salesPitch;
    private HistoricEntity<String> referentTeacherId;
    private HistoricEntity<List<String>> activeMemberIdsResponsibleOfServiceCreation;
    private HistoricEntity<String> requiredSkills; // Saved in database as raw text
    private HistoricEntity<String> competitorIds; // Only a list of enterprises
    private HistoricEntity<String> courseIds; // List of courses which are allowing to provide the service
    private HistoricEntity<List<String>> technicalReferentIds; // List of technical referents (mostly old students) who are able to provide the service, and expert on the subject
    private HistoricEntity<List<String>> commercialReferentIds; // List of active members who are able to sale the service
    private HistoricEntity<String> risksAndLimitations; // Saved in database as raw text
}
