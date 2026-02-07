package com.pseudowasabi.spring_data_access_examples.model.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@IdClass(com.pseudowasabi.spring_data_access_examples.model.jpa.FurnitureId.class)
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
