package com.ringoxcoffee.furniture_fix_request.service;

import com.ringoxcoffee.furniture_fix_request.dto.request.FurnitureFixRequest;
import com.ringoxcoffee.furniture_fix_request.dto.response.FurnitureFixResponse;
import com.ringoxcoffee.furniture_fix_request.model.FurnitureFixStatus;
import com.ringoxcoffee.furniture_fix_request.repository.FurnitureFixStatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SubmitFurnitureFixService {

    private final FurnitureFixStatusRepository furnitureFixStatusRepository;

    public SubmitFurnitureFixService(FurnitureFixStatusRepository furnitureFixStatusRepository) {
        this.furnitureFixStatusRepository = furnitureFixStatusRepository;
    }

    public FurnitureFixResponse process(FurnitureFixRequest furnitureFixRequest, String requestId) {

        log.info("[request_id: {}] furniture fix request is submitted", requestId);

        FurnitureFixStatus furnitureFixStatus = FurnitureFixStatus.builder()
                .requestId(requestId)
                .email(furnitureFixRequest.getEmail())
                .name(furnitureFixRequest.getName())
                .furnitureType(furnitureFixRequest.getFurnitureType())
                .manufacturer(furnitureFixRequest.getManufacturer())
                .requestDetails(furnitureFixRequest.getRequestDetails())
                .status("SUBMIT")
                .build();

        furnitureFixStatusRepository.save(furnitureFixStatus);

        return FurnitureFixResponse.builder()
                .status("submit completed")
                .message("fix schedule will be arranged soon")
                .build();
    }
}
