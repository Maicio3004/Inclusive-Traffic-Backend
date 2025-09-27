package com.uis.project.services.mqtt;

import com.uis.project.dtos.request.ActivationRequest;
import com.uis.project.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MqttService {

    private final TransactionService transactionService;

    private final MqttPublisher mqttPublisher;

    public void publishTest(ActivationRequest request) {
        mqttPublisher.publishTest(request);
    }

    public void createTransaction(ActivationRequest activationRequest) {
        transactionService.createTransaction(activationRequest);
    }

}
