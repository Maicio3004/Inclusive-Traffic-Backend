package com.uis.project.services.mqtt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uis.project.dtos.request.ActivationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MqttPublisher {

    private final MessageChannel outboundChannel;
    private final ObjectMapper objectMapper;

    /**
     * Método de prueba para simular mensaje de ESP32
     * @param request
     */
    public void publishTest(ActivationRequest request) {

        String topic = "";
        String json = "";
        try {
            json = objectMapper.writeValueAsString(request);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Message<String> message = MessageBuilder
                .withPayload(json)
                .setHeader(MqttHeaders.TOPIC, topic)
                .build();

        outboundChannel.send(message);
        System.out.println("Mensaje simulado de la ESP32");
    }

}
