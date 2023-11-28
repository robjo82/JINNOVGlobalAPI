package com.jinnov.jinnovglobalapi.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jinnov.jinnovglobalapi.model.external.monday.LocalGraphQLResponse;
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

    public LocalGraphQLResponse getBoardItems(long boardId, int maxItems, String token) {
        WebGraphQlClient client = clientBuilder
                .header("Authorization", token)
                .build();

        String query = """
                {
                  boards(ids:\s""" + boardId + """
                    ) {
                    items_page(limit:\s""" + maxItems + """
                      ) {
                      items {
                        name
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
            return objectMapper.convertValue(response.getData(), LocalGraphQLResponse.class);
        }

        return null;
    }
}
