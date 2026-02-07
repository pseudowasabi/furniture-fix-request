package com.pseudowasabi.spring_data_access_examples.dto.request;

import lombok.Data;

@Data
public class ChangeStatusbyOriginRequestIdRequest {
    private String originalRequestId;
    private String status;
}
