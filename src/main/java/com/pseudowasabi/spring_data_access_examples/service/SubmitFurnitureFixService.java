package com.pseudowasabi.spring_data_access_examples.service;

import com.pseudowasabi.spring_data_access_examples.dto.request.FurnitureFixRequest;
import com.pseudowasabi.spring_data_access_examples.dto.response.FurnitureFixResponse;
import com.pseudowasabi.spring_data_access_examples.model.jpa.FurnitureFixStatus;
import com.pseudowasabi.spring_data_access_examples.model.jpa.FurnitureFixStatusId;
import com.pseudowasabi.spring_data_access_examples.repository.jdbc.FurnitureFixStatusJdbcRepository;
import com.pseudowasabi.spring_data_access_examples.repository.jpa.FurnitureFixStatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SubmitFurnitureFixService {

    private final FurnitureFixStatusRepository furnitureFixStatusRepository;

    private final FurnitureFixStatusJdbcRepository furnitureFixStatusJdbcRepository;

    public SubmitFurnitureFixService(FurnitureFixStatusRepository furnitureFixStatusRepository,
                                     FurnitureFixStatusJdbcRepository furnitureFixStatusJdbcRepository) {
        this.furnitureFixStatusRepository = furnitureFixStatusRepository;
        this.furnitureFixStatusJdbcRepository = furnitureFixStatusJdbcRepository;
    }


    public void saveIfNotExists(FurnitureFixStatus furnitureFixStatus) {
        if (furnitureFixStatusRepository.existsById(
                FurnitureFixStatusId.builder()
                        .requestId(furnitureFixStatus.getRequestId())
                        .build()
        )) {
            throw new IllegalArgumentException(String.format("Entity with ID %s already exists.", furnitureFixStatus.getRequestId()));
        }
        furnitureFixStatusRepository.save(furnitureFixStatus);
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

        this.saveIfNotExists(furnitureFixStatus);

        return FurnitureFixResponse.builder()
                .status("submit completed")
                .message("fix schedule will be arranged soon")
                .build();
    }
}
