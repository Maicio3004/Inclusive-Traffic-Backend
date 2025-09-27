package com.uis.project.services.mqtt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uis.project.dtos.request.ActivationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MqttSubscriber {

    private final MqttService mqttService;

    private final ObjectMapper objectMapper;

    @ServiceActivator(inputChannel = "inboundChannel")
    public void subscribe(Message<?> request) {

        ActivationRequest activationRequest;

        try {

            Object payload = request.getPayload();

            if(payload instanceof byte[] bytes) {
                activationRequest = objectMapper.readValue(bytes, ActivationRequest.class);
            } else if(payload instanceof String json) {
                activationRequest = objectMapper.readValue(json, ActivationRequest.class);
            } else {
                throw new IllegalAccessException("Tipo de payload inesperado: " + payload.getClass());
            }

            System.out.println("RFID code: " + activationRequest.RFIDCode());
            mqttService.createTransaction(activationRequest);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
