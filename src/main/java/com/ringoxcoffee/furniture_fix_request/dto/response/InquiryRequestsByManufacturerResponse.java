package com.ringoxcoffee.furniture_fix_request.dto.response;

import com.ringoxcoffee.furniture_fix_request.dto.response.sub.InquiryRequestByManufacturer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InquiryRequestsByManufacturerResponse {
    Integer totalCount;
    List<InquiryRequestByManufacturer> inquiryRequestByManufacturers;
}
