package com.ringoxcoffee.furniture_fix_request.controller;

import com.ringoxcoffee.furniture_fix_request.dto.request.FurnitureFixRequest;
import com.ringoxcoffee.furniture_fix_request.dto.response.FurnitureFixResponse;
import com.ringoxcoffee.furniture_fix_request.service.SubmitFurnitureFixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/furniture")
public class FurnitureFixRequestController extends BaseController {

    private final SubmitFurnitureFixService submitFurnitureFixService;

    public FurnitureFixRequestController(SubmitFurnitureFixService submitFurnitureFixService) {
        this.submitFurnitureFixService = submitFurnitureFixService;
    }

    @PostMapping("/fix")
    public ResponseEntity<?> submitFurnitureFixRequest(@RequestHeader("request_id") String requestId,
                                                       @RequestBody FurnitureFixRequest furnitureFixRequest) {

        FurnitureFixResponse result = submitFurnitureFixService.process(furnitureFixRequest, requestId);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
