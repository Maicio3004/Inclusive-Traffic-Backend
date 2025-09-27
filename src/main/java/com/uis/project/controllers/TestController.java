package com.uis.project.controllers;

import com.uis.project.dtos.request.ActivationRequest;
import com.uis.project.services.mqtt.MqttService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final MqttService mqttService;

    @PostMapping("/activate")
    public ResponseEntity<Void> test(@RequestBody ActivationRequest request) {
        mqttService.publishTest(request);
        return ResponseEntity.ok().build();
    }

}
