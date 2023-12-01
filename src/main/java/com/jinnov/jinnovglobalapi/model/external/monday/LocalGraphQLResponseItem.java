package com.jinnov.jinnovglobalapi.model.external.monday;

import lombok.Data;

import java.util.List;

@Data
public class LocalGraphQLResponseItem {
    private String name;
    private String id;
    private List<ColumnValue> column_values;
    private List<SubItem> subitems;

    @Data
    public static class ColumnValue {
        private String id;
        private String text;
    }

    @Data
    public static class SubItem {
        private String name;
        private List<ColumnValue> column_values;
    }
}
