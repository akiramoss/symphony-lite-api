package com.symphony.symphony_lite_api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpaceResponse {

    private Long id;
    private String name;
    private String description;
}
