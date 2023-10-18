package com.jinnov.jinnovglobalapi.model.entities;

import com.jinnov.jinnovglobalapi.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Contractor extends BaseEntity {
    private String contractorId;
    private Integer retribution;
}
