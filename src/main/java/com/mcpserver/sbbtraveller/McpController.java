package com.mcpserver.sbbtraveller;

import com.fasterxml.jackson.databind.JsonNode;
import com.mcpserver.sbbtraveller.model.McpRequest;
import com.mcpserver.sbbtraveller.model.McpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mcp")
public class McpController {

    @Autowired
    private SbbApiService sbbApiService;

    @PostMapping
    public Mono<McpResponse> handleMcp(@RequestBody McpRequest request) {
        Mono<JsonNode> resultMono;

        switch (request.getIntent()) {
            case "getConnections":
                resultMono = sbbApiService.getConnections(request.getPayload());
                break;
            case "getStationboard":
                resultMono = sbbApiService.getStationboard(request.getPayload());
                break;
            default:
                return Mono.error(new IllegalArgumentException("Unknown intent: " + request.getIntent()));
        }

        return resultMono.map(payload -> {
            McpResponse response = new McpResponse();
            response.setContext(request.getContext());
            response.setIntent(request.getIntent());
            response.setPayload(payload);
            return response;
        });
    }
}