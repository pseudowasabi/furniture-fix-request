package com.ringoxcoffee.furniture_fix_request.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(ManufacturerId.class)
public class Manufacturer {

    @Id
    private String manufacturer;

    private String hqLocation;
    private String serviceCenterContact;
}
