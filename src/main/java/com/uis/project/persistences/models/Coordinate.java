package com.uis.project.persistences.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class Coordinate {
    private Float latitude;
    private Float longitude;
}
