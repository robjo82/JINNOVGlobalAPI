package com.jinnov.jinnovglobalapi.model.entities;


import com.jinnov.jinnovglobalapi.model.BaseEntity;
import com.jinnov.jinnovglobalapi.model.HistoricEntity;
import com.jinnov.jinnovglobalapi.model.enums.AcquisitionMethod;
import com.jinnov.jinnovglobalapi.model.enums.AcquisitionStep;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Study extends BaseEntity {
    private HistoricEntity<String> reference;
    private HistoricEntity<String> clientId;
    private HistoricEntity<String> projectManagerId;
    private HistoricEntity<List<Contractor>> contractors;
    private HistoricEntity<AcquisitionStep> acquisitionStep;
    private HistoricEntity<List<Document>> documents;
    private HistoricEntity<Integer> JEHUnitPrice; // Value have to be set between 80 and 480 euros
    private HistoricEntity<List<Phase>> phases;
    private HistoricEntity<AcquisitionMethod> acquisitionMethod;
    private HistoricEntity<Boolean> subContracting;
    private HistoricEntity<Float> studyFees;
    private HistoricEntity<List<Interaction>> interactions;
    private HistoricEntity<List<Meeting>> meetings;
    private HistoricEntity<String> specifications; // Saved in database as markdown
    private HistoricEntity<Float> advanceInvoicePercentage; // Percentage of the total price of the study that will be invoiced at the beginning of the study
    private HistoricEntity<Float> finalInvoicePercentage; // It's important to set securities on the sum of the percentages of the advance, interim and final invoices
}
