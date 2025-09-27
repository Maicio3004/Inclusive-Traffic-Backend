package com.uis.project.dtos.response;

import java.util.Map;


public record UserResponse(
        Long id,
        String email,
        String type,
        Map<String, Object> details
) {}
