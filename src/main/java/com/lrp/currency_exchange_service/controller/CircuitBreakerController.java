package com.lrp.currency_exchange_service.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/v1/circuit-breaker")
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
    @GetMapping("/sample-api")
    //@Re@try(name = "sample-api-retry", fallbackMethod = "hardCodeResponse")
    @CircuitBreaker(name = "sample-api-retry", fallbackMethod = "hardCodeResponse")
    @RateLimiter(name = "default")
    @Bulkhead(name = "default") //how many concurrent calls
    public String sampleAPI() {
        logger.info("Sample API Received . . .");
        //Comment for rate limiting and bulk head sample
//        ResponseEntity<String> forEntity = new RestTemplate()
//                .getForEntity("http://localhost:8080/nonExisting.html", String.class);
//        return forEntity.getBody();
        return "Sample API";
    }

    public String hardCodeResponse(Exception ex){
        return "fallback-response";
    }

}
