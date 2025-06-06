package com.mcpserver.sbbtraveller.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object getTrainConnections(String fromStation, String toStation) {
        String url = String.format("https://api.sbb.ch/v1/connections?from=%s&to=%s", fromStation, toStation);
        return restTemplate.getForObject(url, Object.class);
    }

    public Object getStationInformation(String stationId) {
        String url = String.format("https://api.sbb.ch/v1/station/%s", stationId);
        return restTemplate.getForObject(url, Object.class);
    }
}