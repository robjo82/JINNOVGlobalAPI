package com.jinnov.jinnovglobalapi.model.entities;

import com.google.cloud.Timestamp;
import com.jinnov.jinnovglobalapi.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Phase extends BaseEntity {
    private Integer number;
    private String title;
    private String description;
    private Integer plannedStartDate; // In weeks from the beginning of the study
    private Timestamp realStartDate;
    private Integer plannedEndDate; // In weeks from the beginning of the study
    private Timestamp realEndDate;
    private Integer numberOfJEH; // Number of JEH needed for this phase
    private String deliverable; // What the client will receive at the end of this phase
    private Boolean checkPoint; // If true, the project manager will have to organize a meeting with the client at the end of this phase and present the deliverable
    private Float interimInvoicePercentage; // Percentage of the total price of the study that will be invoiced at the end of this phase
    private List<String> contractorsIds; // List of the contractors that will work on this phase
    private List<Phase> subPhases; // List of the sub phases of this phase (if any, please set only number, title, description and numberOfJEH)
}
