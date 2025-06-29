package com.mcpserver.sbbtraveller.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.mcpserver.sbbtraveller.SbbApiService;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final SbbApiService apiService;

    @Autowired
    public ApiController(SbbApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/api/connections")
    public Mono<JsonNode> getConnections(@RequestBody JsonNode request) {
        return apiService.getConnections(request);
    }

    @GetMapping("/api/journeys")
    public Mono<JsonNode> getStationboard(@RequestBody JsonNode request) {
        return apiService.getStationboard(request);
    }
}