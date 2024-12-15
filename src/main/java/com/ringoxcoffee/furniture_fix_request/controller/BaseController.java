package com.ringoxcoffee.furniture_fix_request.controller;

import org.springframework.http.HttpHeaders;

public abstract class BaseController {

    public BaseController() {

    }

    public HttpHeaders createHttpHeaders(String request_id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("request_id", request_id);
        return httpHeaders;
    }
}
