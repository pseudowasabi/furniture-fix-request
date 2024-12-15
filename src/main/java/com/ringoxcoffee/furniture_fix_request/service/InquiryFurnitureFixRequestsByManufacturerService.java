package com.ringoxcoffee.furniture_fix_request.service;

import com.ringoxcoffee.furniture_fix_request.dto.request.FurnitureFixRequest;
import com.ringoxcoffee.furniture_fix_request.dto.request.InquiryRequestsByManufacturerRequest;
import com.ringoxcoffee.furniture_fix_request.dto.response.InquiryRequestsByManufacturerResponse;
import com.ringoxcoffee.furniture_fix_request.dto.response.sub.InquiryRequestByManufacturer;
import com.ringoxcoffee.furniture_fix_request.global.exception.FurnitureFixRequestException;
import com.ringoxcoffee.furniture_fix_request.model.FurnitureFixStatusProjection;
import com.ringoxcoffee.furniture_fix_request.repository.FurnitureFixStatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class InquiryFurnitureFixRequestsByManufacturerService {

    private final FurnitureFixStatusRepository furnitureFixStatusRepository;

    public InquiryFurnitureFixRequestsByManufacturerService(FurnitureFixStatusRepository furnitureFixStatusRepository) {
        this.furnitureFixStatusRepository = furnitureFixStatusRepository;
    }

    public InquiryRequestsByManufacturerResponse process(InquiryRequestsByManufacturerRequest inquiryRequestsByManufacturerRequest, String requestId) {

        List<FurnitureFixStatusProjection> furnitureFixStatusProjections = furnitureFixStatusRepository.getFixStatusOfSpecificManufacturer(inquiryRequestsByManufacturerRequest.getManufacturer());

        if (furnitureFixStatusProjections.isEmpty()) {
            log.error("No result of getFixStatusOfSpecificManufacturer - request_id: {}", requestId);
            throw new FurnitureFixRequestException("No result of getFixStatusOfSpecificManufacturer");
        }

        List<InquiryRequestByManufacturer> inquiryRequestByManufacturers = new ArrayList<>();

        furnitureFixStatusProjections.forEach(
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
