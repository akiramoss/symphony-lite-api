package com.symphony.symphony_lite_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateSpaceRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String description;
}
