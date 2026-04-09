package com.symphony.symphony_lite_api.controller;

import com.symphony.symphony_lite_api.service.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/spaces")
@RequiredArgsConstructor
public class SpaceController {

    private final SpaceService spaceService;

    @PostMapping("/{spaceId}/join/{userId}")
    public String joinSpace(@PathVariable Long spaceId, @PathVariable Long userId) {

        spaceService.joinSpace(spaceId, userId);

        return "User joined space successfully";
    }
}
