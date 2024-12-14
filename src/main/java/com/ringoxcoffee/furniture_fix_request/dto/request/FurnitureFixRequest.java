package com.ringoxcoffee.furniture_fix_request.dto.request;

import lombok.Data;

@Data
public class FurnitureFixRequest {
    private String email;
    private String name;

    private String furnitureType;
    private String manufacturer;
    private String requestDetails;
}
