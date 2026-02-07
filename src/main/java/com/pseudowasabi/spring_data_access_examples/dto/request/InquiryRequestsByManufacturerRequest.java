package com.pseudowasabi.spring_data_access_examples.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InquiryRequestsByManufacturerRequest {
    private String manufacturer;
}
