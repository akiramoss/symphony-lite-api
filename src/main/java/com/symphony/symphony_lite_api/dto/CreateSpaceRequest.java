package com.symphony.symphony_lite_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Data
public class CreateSpaceRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @PostMapping("/{spaceId}/join/{userId}")
    public String joinSpace(@PathVariable Long spaceId, @PathVariable Long userId) {

        CreateSpaceRequest spaceService = null;
        spaceService.joinSpace(spaceId, userId);

        return "User joined space successfully";
    }
}
