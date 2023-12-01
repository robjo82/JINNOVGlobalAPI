package com.jinnov.jinnovglobalapi.model.external.monday;

import lombok.Data;

@Data
public class LocalGraphQLResponseCreateSubItem {
    private CreateSubitem create_subitem;

    @Data
    public static class CreateSubitem {
        private LocalGraphQLResponseItem parent_item;
    }
}
