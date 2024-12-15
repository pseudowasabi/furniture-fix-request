package com.ringoxcoffee.furniture_fix_request.dto.response.sub;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InquiryRequestByManufacturer {
    String requestId;
    String email;
    String name;
    String furnitureType;
    String manufacturer;
    String requestDetails;
    String status;
    String adminMessage;

    Integer stock;
    Integer supportPeriod;

    String hqLocation;
    String serviceCenterContact;
}
