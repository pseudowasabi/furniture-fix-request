package com.ringoxcoffee.furniture_fix_request.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InquiryRequestsByManufacturerRequest {
    private String manufacturer;
}
