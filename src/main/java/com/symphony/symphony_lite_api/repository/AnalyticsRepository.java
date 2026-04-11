package com.symphony.symphony_lite_api.repository;

import com.symphony.symphony_lite_api.model.Interaction;
import com.symphony.symphony_lite_api.projection.SpaceAnalyticsProjection;
import com.symphony.symphony_lite_api.projection.SpaceCountProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AnalyticsRepository extends JpaRepository<Interaction, Long> {

    @Query("""
                SELECT s.id as spaceId, s.name as name, s.description as description, COUNT(i) as count
                FROM Interaction i
                JOIN Space s ON s.id = i.spaceId
                WHERE i.type = 'JOIN'
                GROUP BY s.id, s.name, s.description
                ORDER BY count DESC
            """)
    List<SpaceAnalyticsProjection> findTopSpaces();

    @Query("""
                SELECT s.id as spaceId, s.name as name, s.description as description, COUNT(i) as count
                FROM Interaction i
                JOIN Space s ON s.id = i.spaceId
                WHERE i.type = 'JOIN'
                AND i.createdAt >= :since
                GROUP BY s.id, s.name, s.description
                ORDER BY count DESC
            """)
    List<SpaceAnalyticsProjection> findTrendingSpaces(LocalDateTime since);
}
