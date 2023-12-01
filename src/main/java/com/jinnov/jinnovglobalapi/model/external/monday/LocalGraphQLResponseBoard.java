package com.jinnov.jinnovglobalapi.model.external.monday;

import lombok.Data;

import java.util.List;

@Data
public class LocalGraphQLResponseBoard {
    private Complexity complexity;
    private List<Board> boards;

    @Data
    public static class Complexity {
        private String after;
        private String query;
        private String reset_in_x_seconds;
    }

    @Data
    public static class Board {
        private ItemsPage items_page;

        @Data
        public static class ItemsPage {
            private String cursor;
            private List<LocalGraphQLResponseItem> items;
        }
    }
}

