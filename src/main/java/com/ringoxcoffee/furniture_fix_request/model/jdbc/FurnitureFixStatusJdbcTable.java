package com.ringoxcoffee.furniture_fix_request.model.jdbc;

import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("furniture_fix_status")
public class FurnitureFixStatusJdbcTable {

    private String email;
    private String name;

    private String furnitureType;
    private String manufacturer;
    private String requestDetails;

    private String status;
    private String adminMessage;

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
