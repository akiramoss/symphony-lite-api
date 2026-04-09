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

    public SpaceResponse joinSpace(Long spaceId, Long userId) {

        Space space = spaceRepository.findById(spaceId)
                .orElseThrow(() -> new ApiException("Space " + spaceId + " not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ApiException("User with id "  + userId + " not found"));

        boolean alreadyJoined = space.getUsers().stream()
                .anyMatch(u -> u.getId().equals(userId));

        if(alreadyJoined){
            throw new ApiException("User with id " + userId + " joined already");
        }

        space.getUsers().add(user);

        spaceRepository.save(space);

        return SpaceResponse.builder()
                .id(space.getId())
                .name(space.getName())
                .description(space.getDescription())
                .build();
    }
}
