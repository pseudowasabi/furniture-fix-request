package com.ringoxcoffee.furniture_fix_request.service;

import com.ringoxcoffee.furniture_fix_request.dto.request.InquiryRequestsByManufacturerRequest;
import com.ringoxcoffee.furniture_fix_request.dto.response.InquiryRequestsByManufacturerResponse;
import com.ringoxcoffee.furniture_fix_request.dto.response.sub.InquiryRequestByManufacturer;
import com.ringoxcoffee.furniture_fix_request.global.exception.FurnitureFixRequestException;
import com.ringoxcoffee.furniture_fix_request.model.jdbc.FurnitureFixStatusSelectResult;
import com.ringoxcoffee.furniture_fix_request.repository.jdbc.FurnitureFixStatusJdbcRepository;
import com.ringoxcoffee.furniture_fix_request.repository.jpa.FurnitureFixStatusRepository;
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
