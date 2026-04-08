package com.symphony.symphony_lite_api.service;

import com.symphony.symphony_lite_api.dto.CreateSpaceRequest;
import com.symphony.symphony_lite_api.dto.SpaceResponse;
import com.symphony.symphony_lite_api.exception.ApiException;
import com.symphony.symphony_lite_api.model.Space;
import com.symphony.symphony_lite_api.model.User;
import com.symphony.symphony_lite_api.repository.SpaceRepository;
import com.symphony.symphony_lite_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpaceService {

    private final SpaceRepository spaceRepository;
    private final UserRepository userRepository;

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

    public void joinSpace(Long spaceId, Long userId) {

        Space space = spaceRepository.findById(spaceId)
                .orElseThrow(() -> new ApiException("Space not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ApiException("User not found"));

        if (space.getUsers().contains(user)) {
            throw new ApiException("User already in space");
        }
        space.getUsers().add(user);

        spaceRepository.save(space);
    }
}
