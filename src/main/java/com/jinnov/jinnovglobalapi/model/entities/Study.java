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
}
