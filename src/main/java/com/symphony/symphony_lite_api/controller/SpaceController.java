package com.symphony.symphony_lite_api.controller;

import com.symphony.symphony_lite_api.dto.CreateSpaceRequest;
import com.symphony.symphony_lite_api.dto.SpaceResponse;
import com.symphony.symphony_lite_api.service.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spaces")
@RequiredArgsConstructor
public class SpaceController {

    private final SpaceService spaceService;

    @PostMapping
    public SpaceResponse createSpace(@RequestBody /**/CreateSpaceRequest request) {
        return spaceService.createSpace(request);
    }

    @PostMapping("/{spaceId}/join/{userId}")
    public String joinSpace(@PathVariable Long spaceId, @PathVariable Long userId) {

        spaceService.joinSpace(spaceId, userId);

        return "User joined space successfully";
    }

    @GetMapping("/top")
    public List<SpaceResponse> getTopSpaces() {
        return spaceService.getTopSpaces();
    }

    @GetMapping("/trending")
    public List<SpaceResponse> getTrendingSpaces(@RequestParam int hours) {
        return spaceService.getTrendingSpaces(hours);
    }
}
