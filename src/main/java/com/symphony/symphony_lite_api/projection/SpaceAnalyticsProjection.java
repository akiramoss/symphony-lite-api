package com.symphony.symphony_lite_api.projection;

import java.time.LocalDateTime;

public interface SpaceAnalyticsProjection {

    Long getSpaceId();

    String getName();

    String getDescription();

    LocalDateTime findTrendigSpaces();

}
