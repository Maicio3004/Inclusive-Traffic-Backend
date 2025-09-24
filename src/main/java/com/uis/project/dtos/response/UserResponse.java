package com.uis.project.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class UserResponse {

    private Long id;
    private String email;
    private String type;
    private Map<String, Object> details;

}
