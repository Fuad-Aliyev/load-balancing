package com.tutorial.loadbalancer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private Environment environment;

    @GetMapping("/get/1")
    public String sampleApi() {
        logger.info("Sample api call received");
        String port = environment.getProperty("local.server.port");
        return port;
    }

    public String hardcodedResponse(Exception ex) {
        return "fallback-response";
    }
}
