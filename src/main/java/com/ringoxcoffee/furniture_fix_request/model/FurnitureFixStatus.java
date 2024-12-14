package com.ringoxcoffee.furniture_fix_request.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class FurnitureFixStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;

    private String type;
    private String details;

    private String status;
    private String adminMessage;

    private String lastUpdates;
}
