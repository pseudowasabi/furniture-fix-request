package com.ringoxcoffee.furniture_fix_request.service;

import com.ringoxcoffee.furniture_fix_request.dto.request.ChangeStatusbyOriginRequestIdRequest;
import com.ringoxcoffee.furniture_fix_request.dto.response.ChangeStatusbyOriginRequestIdResponse;
import com.ringoxcoffee.furniture_fix_request.repository.jpa.FurnitureFixStatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ChangeStatusByOriginalRequestIdService {

    private final FurnitureFixStatusRepository furnitureFixStatusRepository;

    public ChangeStatusByOriginalRequestIdService(FurnitureFixStatusRepository furnitureFixStatusRepository) {
        this.furnitureFixStatusRepository = furnitureFixStatusRepository;
    }

    @Transactional
    public ChangeStatusbyOriginRequestIdResponse process(ChangeStatusbyOriginRequestIdRequest changeStatusbyOriginRequestIdRequest, String requestId) {
        int updateCount = furnitureFixStatusRepository.updateStatus(changeStatusbyOriginRequestIdRequest.getOriginalRequestId(), changeStatusbyOriginRequestIdRequest.getStatus());
        return ChangeStatusbyOriginRequestIdResponse.builder().updateCount(updateCount).build();
    }
}
