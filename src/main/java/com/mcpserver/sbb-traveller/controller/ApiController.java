package com.mcpserver.sbbtraveller.controller;

import com.mcpserver.sbbtraveller.service.ApiService;
import com.mcpserver.sbbtraveller.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/api/tools")
    public ApiResponse getTools(@RequestParam String toolType) {
        return apiService.fetchTools(toolType);
    }

    @GetMapping("/api/journeys")
    public ApiResponse getJourneys(@RequestParam String from, @RequestParam String to) {
        return apiService.fetchJourneys(from, to);
    }
}