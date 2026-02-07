package com.pseudowasabi.spring_data_access_examples.model.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FurnitureFixStatusSelectResult {

    // from furniture_fix_status table
    private String requestId;
    private String email;
    private String name;
    private String furnitureType;
    private String manufacturer;
    private String requestDetails;
    private String status;
    private String adminMessage;

    // from furniture table
    private Integer stock;
    private Integer supportPeriod;

    // from manufacturer table
    private String hqLocation;
    private String serviceCenterContact;
}
