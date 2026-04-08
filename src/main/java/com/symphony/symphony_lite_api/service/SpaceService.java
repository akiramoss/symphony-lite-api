package com.symphony.symphony_lite_api.service;

import com.symphony.symphony_lite_api.dto.CreateSpaceRequest;
import com.symphony.symphony_lite_api.dto.SpaceResponse;
import com.symphony.symphony_lite_api.model.Space;
import com.symphony.symphony_lite_api.repository.SpaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpaceService {

    private final SpaceRepository spaceRepository;

    public SpaceResponse createSpace(CreateSpaceRequest request) {

        Space space = Space.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();

        Space saved = spaceRepository.save(space);

        return SpaceResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .description(saved.getDescription())
                .build();
    }
}
