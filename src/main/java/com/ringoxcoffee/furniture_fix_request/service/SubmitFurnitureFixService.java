package com.ringoxcoffee.furniture_fix_request.service;

import com.ringoxcoffee.furniture_fix_request.dto.request.FurnitureFixRequest;
import com.ringoxcoffee.furniture_fix_request.dto.response.FurnitureFixResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SubmitFurnitureFixService {

    public FurnitureFixResponse process(FurnitureFixRequest furnitureFixRequest, String requestId) {

        return FurnitureFixResponse.builder()
                .status("submit completed")
                .message("fix schedule will be arranged soon")
                .build();
    }
}
