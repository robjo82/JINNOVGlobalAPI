package com.jinnov.jinnovglobalapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Schema(
        description = "Monday request DTO is used to add some information to the data returned. It is used to paginate the data and understand when the credits will be reset.",
        accessMode = Schema.AccessMode.READ_ONLY
)
public class MondayRequestDTO<T> {
    @Schema(
            description = "Cursor to use to get the next page of data. If null, it means that there is no more data to get.",
            example = "MSw1MDUwxMiwxLHw3NDYwNDA5MTk"
    )
    private String cursor;

    @Schema(
            description = "Duration in seconds before the credits are reset. Maximum 60 seconds.",
            example = "45"
    )
    private Integer resetIn;

    @Schema(
            description = "The number of such requests that can be made before the credits are reset.",
            example = "3"
    )
    private Integer requestAvailable;
    private T data;
}
