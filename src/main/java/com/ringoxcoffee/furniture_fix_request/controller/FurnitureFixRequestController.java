package com.ringoxcoffee.furniture_fix_request.controller;

import com.ringoxcoffee.furniture_fix_request.dto.request.FurnitureFixRequest;
import com.ringoxcoffee.furniture_fix_request.dto.response.FurnitureFixResponse;
import com.ringoxcoffee.furniture_fix_request.service.ReceiptFurnitureFixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/furniture")
public class FurnitureFixRequestController extends BaseController {

    private final ReceiptFurnitureFixService receiptFurnitureFixService;

    public FurnitureFixRequestController(ReceiptFurnitureFixService receiptFurnitureFixService) {
        this.receiptFurnitureFixService = receiptFurnitureFixService;
    }

    @PostMapping("/fix")
    public ResponseEntity<?> receiptFurnitureFixRequest(@RequestHeader("request_id") String requestId,
                                                        @RequestBody FurnitureFixRequest furnitureFixRequest) {

        FurnitureFixResponse result = receiptFurnitureFixService.process(furnitureFixRequest, requestId);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
