package com.pseudowasabi.spring_data_access_examples.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChangeStatusbyOriginRequestIdResponse {
    Integer updateCount;
}
