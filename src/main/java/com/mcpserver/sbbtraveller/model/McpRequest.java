package com.mcpserver.sbbtraveller.model;

import com.fasterxml.jackson.databind.JsonNode;

public class McpRequest {
    private JsonNode context;
    private String intent;
    private JsonNode payload;
    public JsonNode getContext() {
        return context;
    }
    public void setContext(JsonNode context) {
        this.context = context;
    }
    public String getIntent() {
        return intent;
    }
    public void setIntent(String intent) {
        this.intent = intent;
    }
    public JsonNode getPayload() {
        return payload;
    }
    public void setPayload(JsonNode payload) {
        this.payload = payload;
    }

    // getters and setters
}