package com.jinnov.jinnovglobalapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HistoricEntity<T> {
    private List<HistoryField<T>> fields;
}
