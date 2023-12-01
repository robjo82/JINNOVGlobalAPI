package com.jinnov.jinnovglobalapi.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jinnov.jinnovglobalapi.model.external.monday.LocalGraphQLResponseBoard;
import com.jinnov.jinnovglobalapi.model.external.monday.LocalGraphQLResponseCreateSubItem;
import org.springframework.graphql.GraphQlResponse;
import org.springframework.graphql.client.WebGraphQlClient;
import org.springframework.stereotype.Repository;
import org.springframework.graphql.client.HttpGraphQlClient;

@Repository
public class MondayRepositoryImpl {

    private static final String API_URL = "https://api.monday.com/v2";
    private static final String API_VERSION = "2023-10";

    private final HttpGraphQlClient.Builder clientBuilder;
    private final ObjectMapper objectMapper;
    public MondayRepositoryImpl() {
        this.clientBuilder = HttpGraphQlClient.builder()
                .url(API_URL)
                .header("Content-Type", "application/json")
                .header("API-Version", API_VERSION);
        this.objectMapper = new ObjectMapper();
    }

    public LocalGraphQLResponseBoard getBoardItems(String boardId, String maxItems, String cursor, String token) {
        WebGraphQlClient client = clientBuilder
                .header("Authorization", token)
                .build();

        String query = """
                {
                  complexity{
                      after
                      query
                      reset_in_x_seconds
                    }
                  boards(ids:\s""" + boardId + """
                    ) {
                    items_page(limit:\s""" + maxItems + ", cursor: " + cursor + """
                      ) {
                      cursor
                      items {
                        name
                        id
                        column_values {
                          id
                          text
                        }
                        subitems {
                          column_values {
                            id
                            text
                          }
                        }
                      }
                    }
                  }
                }""";

        GraphQlResponse response = client.document(query)
                .execute()
                .block();

        if (response != null && response.getData() != null) {
            return objectMapper.convertValue(response.getData(), LocalGraphQLResponseBoard.class);
        }

        return null;
    }

    public LocalGraphQLResponseCreateSubItem addSubItem(String itemId, String subItemName, String columnValues, String token) {
        WebGraphQlClient client = clientBuilder
                .header("Authorization", token)
                .build();

        String query = """
                mutation {
                  create_subitem(
                    parent_item_id:\s""" + itemId + ", " +
                    "item_name: \"" + subItemName + "\"" + ", " +
                    "column_values:" + columnValues + """
                  ) {
                    parent_item {
                      name
                      id
                      column_values {
                        id
                        text
                      }
                      subitems {
                        column_values {
                          id
                          text
                        }
                      }
                    }
                  }
                }""";

        GraphQlResponse response = client.document(query)
                .execute()
                .block();

        if (response != null && response.getData() != null) {
            return objectMapper.convertValue(response.getData(), LocalGraphQLResponseCreateSubItem.class);
        }

        return null;
    }
}
