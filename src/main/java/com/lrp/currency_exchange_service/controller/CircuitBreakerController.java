package com.lrp.currency_exchange_service.controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(name = "/v1/circuit-breaker")
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
    @GetMapping("/sample-api")
    @Retry(name = "sample-api-retry", fallbackMethod = "hardCodeResponse")
    public String sampleAPI() {
        logger.info("Sample API Received . . .");
        ResponseEntity<String> forEntity = new RestTemplate()
                .getForEntity("http://localhost:8080/nonExisting.html", String.class);
        return forEntity.getBody();
    }

    public String hardCodeResponse(Exception ex){
        return "fallback-response";
    }

}
