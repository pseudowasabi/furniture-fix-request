package com.pseudowasabi.spring_data_access_examples.service;

import com.pseudowasabi.spring_data_access_examples.dto.request.ChangeStatusbyOriginRequestIdRequest;
import com.pseudowasabi.spring_data_access_examples.dto.response.ChangeStatusbyOriginRequestIdResponse;
import com.pseudowasabi.spring_data_access_examples.repository.jdbc.FurnitureFixStatusJdbcRepository;
import com.pseudowasabi.spring_data_access_examples.repository.jpa.FurnitureFixStatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ChangeStatusByOriginalRequestIdService {

    private final FurnitureFixStatusRepository furnitureFixStatusRepository;

    private final FurnitureFixStatusJdbcRepository furnitureFixStatusJdbcRepository;

    public ChangeStatusByOriginalRequestIdService(FurnitureFixStatusRepository furnitureFixStatusRepository,
                                                  FurnitureFixStatusJdbcRepository furnitureFixStatusJdbcRepository) {
        this.furnitureFixStatusRepository = furnitureFixStatusRepository;
        this.furnitureFixStatusJdbcRepository = furnitureFixStatusJdbcRepository;
    }

    @Transactional
    public ChangeStatusbyOriginRequestIdResponse process(ChangeStatusbyOriginRequestIdRequest changeStatusbyOriginRequestIdRequest, String requestId) {
//        int updateCount = furnitureFixStatusRepository.updateStatus(changeStatusbyOriginRequestIdRequest.getOriginalRequestId(), changeStatusbyOriginRequestIdRequest.getStatus());
        int updateCount = furnitureFixStatusJdbcRepository.updateStatus(changeStatusbyOriginRequestIdRequest.getOriginalRequestId(), changeStatusbyOriginRequestIdRequest.getStatus());
        return ChangeStatusbyOriginRequestIdResponse.builder().updateCount(updateCount).build();
    }
}
