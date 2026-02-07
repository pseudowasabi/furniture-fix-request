package com.pseudowasabi.spring_data_access_examples.dto.response;

import com.pseudowasabi.spring_data_access_examples.dto.response.sub.InquiryRequestByManufacturer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InquiryRequestsByManufacturerResponse {
    Integer totalCount;
    List<InquiryRequestByManufacturer> inquiryRequestByManufacturers;
}
