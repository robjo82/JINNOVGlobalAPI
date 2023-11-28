package com.jinnov.jinnovglobalapi.model.external.monday;

import lombok.Data;

import java.util.List;

@Data
public class LocalGraphQLResponse {
    private List<Board> boards;

    @Data
    public static class Board {
        private ItemsPage items_page;

        @Data
        public static class ItemsPage {
            private List<Item> items;

            @Data
            public static class Item {
                private String name;
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
        }
    }
}

