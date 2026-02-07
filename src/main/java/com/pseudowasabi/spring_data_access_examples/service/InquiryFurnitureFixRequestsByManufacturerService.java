package com.pseudowasabi.spring_data_access_examples.service;

import com.pseudowasabi.spring_data_access_examples.dto.request.InquiryRequestsByManufacturerRequest;
import com.pseudowasabi.spring_data_access_examples.dto.response.InquiryRequestsByManufacturerResponse;
import com.pseudowasabi.spring_data_access_examples.dto.response.sub.InquiryRequestByManufacturer;
import com.pseudowasabi.spring_data_access_examples.global.exception.FurnitureFixRequestException;
import com.pseudowasabi.spring_data_access_examples.model.jdbc.FurnitureFixStatusSelectResult;
import com.pseudowasabi.spring_data_access_examples.repository.jdbc.FurnitureFixStatusJdbcRepository;
import com.pseudowasabi.spring_data_access_examples.repository.jpa.FurnitureFixStatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class InquiryFurnitureFixRequestsByManufacturerService {

    private final FurnitureFixStatusRepository furnitureFixStatusRepository;

    private final FurnitureFixStatusJdbcRepository furnitureFixStatusJdbcRepository;

    public InquiryFurnitureFixRequestsByManufacturerService(FurnitureFixStatusRepository furnitureFixStatusRepository,
                                                            FurnitureFixStatusJdbcRepository furnitureFixStatusJdbcRepository) {
        this.furnitureFixStatusRepository = furnitureFixStatusRepository;
        this.furnitureFixStatusJdbcRepository = furnitureFixStatusJdbcRepository;
    }

    public InquiryRequestsByManufacturerResponse process(InquiryRequestsByManufacturerRequest inquiryRequestsByManufacturerRequest, String requestId) {

//        List<FurnitureFixStatusProjection> furnitureFixStatusList = furnitureFixStatusRepository.getFixStatusOfSpecificManufacturer(inquiryRequestsByManufacturerRequest.getManufacturer());
        List<FurnitureFixStatusSelectResult> furnitureFixStatusList = furnitureFixStatusJdbcRepository.getFixStatusOfSpecificManufacturer(inquiryRequestsByManufacturerRequest.getManufacturer());

        if (furnitureFixStatusList.isEmpty()) {
            log.error("No result of getFixStatusOfSpecificManufacturer - request_id: {}", requestId);
            throw new FurnitureFixRequestException("No result of getFixStatusOfSpecificManufacturer");
        }

        List<InquiryRequestByManufacturer> inquiryRequestByManufacturers = new ArrayList<>();

        furnitureFixStatusList.forEach(
                item -> inquiryRequestByManufacturers.add(
                        InquiryRequestByManufacturer.builder()
                                .requestId(item.getRequestId())
                                .email(item.getEmail())
                                .name(item.getName())
                                .furnitureType(item.getFurnitureType())
                                .manufacturer(item.getManufacturer())
                                .requestDetails(item.getRequestDetails())
                                .status(item.getStatus())
                                .adminMessage(item.getAdminMessage())
                                .stock(item.getStock())
                                .supportPeriod(item.getSupportPeriod())
                                .hqLocation(item.getHqLocation())
                                .serviceCenterContact(item.getServiceCenterContact())
                                .build()
                )
        );

        return InquiryRequestsByManufacturerResponse.builder()
                .totalCount(inquiryRequestByManufacturers.size())
                .inquiryRequestByManufacturers(inquiryRequestByManufacturers)
                .build();
    }
}
