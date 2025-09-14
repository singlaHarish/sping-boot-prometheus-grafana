package com.example.demo.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class HelloController {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Counter incrementCounter;

    @Autowired
    public HelloController(MeterRegistry meterRegistry) {
        // Create a Prometheus counter metric for increments
        this.incrementCounter = Counter.builder("api_counter_increments_total")
                .description("Total number of counter increments")
                .register(meterRegistry);
        
        // Create a Prometheus gauge metric for current counter value
        Gauge.builder("api_counter_current_value", this, HelloController::getCurrentCounterValue)
                .description("Current value of the counter")
                .register(meterRegistry);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello, Spring Boot with Java 17!";
    }

    @GetMapping("/health")
    public String health() {
        return "Application is running";
    }

    @PostMapping("/counter/increment")
    public int incrementCounter() {
        int newValue = counter.incrementAndGet();
        incrementCounter.increment();
        return newValue;
    }

    @GetMapping("/counter")
    public int getCounter() {
        return counter.get();
    }

    private double getCurrentCounterValue() {
        return counter.get();
    }
}