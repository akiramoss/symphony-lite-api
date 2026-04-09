package com.symphony.symphony_lite_api.service;

import com.symphony.symphony_lite_api.model.Interaction;
import com.symphony.symphony_lite_api.model.InteractionType;
import com.symphony.symphony_lite_api.repository.InteractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class InteractionService {

    private final InteractionRepository interactionRepository;

    public void trackInteraction(Long userId, Long spaceId, InteractionType type) {
        Interaction interaction = Interaction.builder()
                .userId(userId)
                .spaceId(spaceId)
                .type(type)
                .timestamp(LocalDateTime.now())
                .build();

        interactionRepository.save(interaction);
    }
}
