package com.uis.project.services.mqtt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uis.project.dtos.request.ActivationRequest;
import com.uis.project.dtos.response.ActivationResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MqttSubscriber {

    private final MqttService mqttService;
    private final ObjectMapper objectMapper;

    private final static Logger LOGGER = LoggerFactory.getLogger(MqttSubscriber.class);

    @ServiceActivator(inputChannel = "inboundChannel")
    public void subscribe(Message<?> request) {

        ActivationRequest activationRequest;

        try {

            Object payload = request.getPayload();

            if (payload instanceof String json) {
                // Ya es JSON en texto
                activationRequest = objectMapper.readValue(json, ActivationRequest.class);
            } else if (payload instanceof byte[] bytes) {
                // Viene como bytes
                activationRequest = objectMapper.readValue(bytes, ActivationRequest.class);
            } else {
                // Ya está como mapa u objeto (Spring puede hacerlo)
                activationRequest = objectMapper.convertValue(payload, ActivationRequest.class);
            }

            if(activationRequest.getRFIDCode() == null) {
                int startIndex = payload.toString().indexOf(":");
                String newString = payload.toString().substring(startIndex + 2);
                int endIndex = newString.indexOf('"');
                activationRequest.setRFIDCode(newString.substring(0, endIndex));
            }

            mqttService.createTransaction(activationRequest);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }

    }

}
