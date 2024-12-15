package com.ringoxcoffee.furniture_fix_request.controller;

import com.ringoxcoffee.furniture_fix_request.dto.request.ChangeStatusbyOriginRequestIdRequest;
import com.ringoxcoffee.furniture_fix_request.dto.request.FurnitureFixRequest;
import com.ringoxcoffee.furniture_fix_request.dto.request.InquiryRequestsByManufacturerRequest;
import com.ringoxcoffee.furniture_fix_request.dto.response.ChangeStatusbyOriginRequestIdResponse;
import com.ringoxcoffee.furniture_fix_request.dto.response.FurnitureFixResponse;
import com.ringoxcoffee.furniture_fix_request.dto.response.InquiryRequestsByManufacturerResponse;
import com.ringoxcoffee.furniture_fix_request.service.ChangeStatusByOriginalRequestIdService;
import com.ringoxcoffee.furniture_fix_request.service.InquiryFurnitureFixRequestsByManufacturerService;
import com.ringoxcoffee.furniture_fix_request.service.SubmitFurnitureFixService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/furniture")
public class FurnitureFixRequestController extends BaseController {

    private final SubmitFurnitureFixService submitFurnitureFixService;
    private final InquiryFurnitureFixRequestsByManufacturerService inquiryFurnitureFixRequestsByManufacturerService;
    private final ChangeStatusByOriginalRequestIdService changeStatusByOriginalRequestIdService;

    public FurnitureFixRequestController(SubmitFurnitureFixService submitFurnitureFixService,
                                         InquiryFurnitureFixRequestsByManufacturerService inquiryFurnitureFixRequestsByManufacturerService,
                                         ChangeStatusByOriginalRequestIdService changeStatusByOriginalRequestIdService) {
        this.submitFurnitureFixService = submitFurnitureFixService;
        this.inquiryFurnitureFixRequestsByManufacturerService = inquiryFurnitureFixRequestsByManufacturerService;
        this.changeStatusByOriginalRequestIdService = changeStatusByOriginalRequestIdService;
    }

    @PostMapping("/fix")
    public ResponseEntity<?> submitFurnitureFixRequest(@RequestHeader("request_id") String requestId,
                                                       @RequestBody FurnitureFixRequest furnitureFixRequest) throws HttpMessageNotReadableException {
        FurnitureFixResponse result = submitFurnitureFixService.process(furnitureFixRequest, requestId);
        HttpHeaders httpHeaders = super.createHttpHeaders(requestId);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(result);
    }

    @GetMapping("/requests-by-manufacturer")
    public ResponseEntity<?> inquiryFurnitureFixRequestsByManufacturer(@RequestHeader("request_id") String requestId,
                                                                       @RequestParam String manufacturer) throws HttpMessageNotReadableException {
        InquiryRequestsByManufacturerRequest inquiryRequestsByManufacturerRequest = InquiryRequestsByManufacturerRequest.builder().manufacturer(manufacturer).build();
        InquiryRequestsByManufacturerResponse result = inquiryFurnitureFixRequestsByManufacturerService.process(inquiryRequestsByManufacturerRequest, requestId);
        HttpHeaders httpHeaders = super.createHttpHeaders(requestId);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(result);
    }

    @PatchMapping("/status")
    public ResponseEntity<?> changeStatusByOriginalRequestId(@RequestHeader("request_id") String requestId,
                                                             @RequestBody ChangeStatusbyOriginRequestIdRequest changeStatusbyOriginRequestIdRequest) throws HttpMessageNotReadableException {
        ChangeStatusbyOriginRequestIdResponse result = changeStatusByOriginalRequestIdService.process(changeStatusbyOriginRequestIdRequest, requestId);
        HttpHeaders httpHeaders = super.createHttpHeaders(requestId);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(result);
    }


}
