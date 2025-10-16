package com.uis.project.services.mqtt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uis.project.dtos.request.ActivationRequest;
import com.uis.project.dtos.response.ActivationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${mqtt.topics.activate-topic}")
    private String BASE_ACTIVATE_TOPIC;

    public void activateIntersection(ActivationResponse response) {

        String json = writeValueAsString(response.payload());
        String topic = BASE_ACTIVATE_TOPIC + response.endTopic();

        Message<String> message = MessageBuilder
                .withPayload(json)
                .setHeader(MqttHeaders.TOPIC, topic)
                .build();

        outboundChannel.send(message);
    }

    private String writeValueAsString(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
