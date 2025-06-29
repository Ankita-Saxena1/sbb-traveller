package com.mcpserver.sbbtraveller;

import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class SbbApiService {

    private final WebClient webClient;

    public SbbApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://transport.opendata.ch/v1").build();
    }

    // Fetch connections between two locations, return as JsonNode
    @Tool(description="Fetch connections between two locations (from and to) from the SBB API. ")
    public Mono<JsonNode> getConnections(JsonNode request) {
        String from = request.path("from").asText();
        String to = request.path("to").asText();
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/connections")
                        .queryParam("from", from)
                        .queryParam("to", to)
                        .build())
                .retrieve()
                .bodyToMono(JsonNode.class);
    }

    // Fetch stationboard for a station, return as JsonNode
    @Tool(description="Fetch stationboard for a specific station from the SBB API. ")
    public Mono<JsonNode> getStationboard(JsonNode request) {
        String station = request.path("station").asText();
        int limit = request.path("limit").asInt(10); // default limit 10
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/stationboard")
                        .queryParam("station", station)
                        .queryParam("limit", limit)
                        .build())
                .retrieve()
                .bodyToMono(JsonNode.class);
    }
}