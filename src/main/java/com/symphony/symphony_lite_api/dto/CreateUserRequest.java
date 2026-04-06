package com.symphony.symphony_lite_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserRequest {
    // Nunca exponer entidades directamente

    @NotBlank
    private String username;

    @Email
    private String email;
}
