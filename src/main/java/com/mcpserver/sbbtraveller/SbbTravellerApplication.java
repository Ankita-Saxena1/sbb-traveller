package com.mcpserver.sbbtraveller;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SbbTravellerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbbTravellerApplication.class, args);
    }

    @Bean
	public ToolCallbackProvider weatherTools(SbbApiService sbbApiService) {
		return  MethodToolCallbackProvider.builder().toolObjects(sbbApiService).build();
	}
}