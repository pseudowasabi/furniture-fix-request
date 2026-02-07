package com.pseudowasabi.spring_data_access_examples.model.jpa;

public interface FurnitureFixStatusProjection {

    // from FurnitureFixStatus entity
    String getRequestId();
    String getEmail();
    String getName();
    String getFurnitureType();
    String getManufacturer();
    String getRequestDetails();
    String getStatus();
    String getAdminMessage();

    // from Furniture entity
    Integer getStock();
    Integer getSupportPeriod();

    // from Manufacturer entity
    String getHqLocation();
    String getServiceCenterContact();
}
