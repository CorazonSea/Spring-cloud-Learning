package com.example.trace2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraceController {
    private final Logger logger = LoggerFactory.getLogger(TraceController.class);

    @GetMapping("/trace-2")
    public String trace() {
    	logger.info("===<call trace-2>===");
    	return "Trace";
    }


}
