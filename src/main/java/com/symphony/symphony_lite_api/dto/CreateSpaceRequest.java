package com.symphony.symphony_lite_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateSpaceRequest {

    @NotBlank
    private String spaceName;

    @NotBlank
    private String description;
}
