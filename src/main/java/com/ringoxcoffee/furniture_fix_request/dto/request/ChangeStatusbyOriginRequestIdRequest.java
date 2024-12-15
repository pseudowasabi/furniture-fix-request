package com.ringoxcoffee.furniture_fix_request.dto.request;

import lombok.Data;

@Data
public class ChangeStatusbyOriginRequestIdRequest {
    private String originalRequestId;
    private String status;
}
