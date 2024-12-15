package com.ringoxcoffee.furniture_fix_request.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@IdClass(FurnitureId.class)
@NoArgsConstructor
@AllArgsConstructor
public class Furniture {

    @Id
    private String furnitureType;

    @Id
    private String manufacturer;

    private Integer stock;
    private Integer supportPeriod;
}
