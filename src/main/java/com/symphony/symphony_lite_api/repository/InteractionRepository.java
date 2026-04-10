package com.symphony.symphony_lite_api.repository;

import com.symphony.symphony_lite_api.model.Interaction;
import com.symphony.symphony_lite_api.model.InteractionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InteractionRepository extends JpaRepository<Interaction, Long> {

    List<Interaction> findByUserId(Long userId);

    List<Interaction> findBySpaceId(Long spaceId);

    @Query("""
            SELECT i.spaceId, COUNT(i) as count
            FROM Interaction i
            WHERE i.type = 'JOIN'
            GROUP BY i.spaceId
            ORDER BY count DESC
            """)
    List<Object[]> findTopSpaces();
}
