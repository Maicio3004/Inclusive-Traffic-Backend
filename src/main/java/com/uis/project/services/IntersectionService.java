package com.uis.project.services;

import com.uis.project.dtos.request.ActivationRequest;
import com.uis.project.exceptions.IntersectionNotFound;
import com.uis.project.persistences.models.Intersection;
import com.uis.project.persistences.repositories.IntersectionRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IntersectionService {

    private final IntersectionRepository intersectionRepository;

    private final static Logger LOGGER = LoggerFactory.getLogger(IntersectionService.class);

    /**
     * <p>
     *     Busca la intersección utilizando el código de la misma
     * </p>
     * @param activationRequest DTO de activación que llega de la ESP32
     * @return La {@code Intersection} con sus datos
     * @exception IntersectionNotFound
     */
    public Intersection findByCode(ActivationRequest activationRequest) {
        return intersectionRepository
                .findByCode(activationRequest.getCodeIntersection())
                .orElseThrow(() -> {
                    LOGGER.error("Invalid Intersection Code: {}",
                            activationRequest.getCodeIntersection());

                    return new IntersectionNotFound("Intersection not found");
                });
    }

}
