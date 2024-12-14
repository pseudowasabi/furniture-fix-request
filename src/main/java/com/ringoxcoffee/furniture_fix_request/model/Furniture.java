package com.ringoxcoffee.furniture_fix_request.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(FurnitureId.class)
public class Furniture {

    @Id
    private String furnitureType;

    @Id
    private String manufacturer;

    private String stock;
    private String supportPeriod;
}
