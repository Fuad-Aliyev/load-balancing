package com.tutorial.loadbalancer.controller;

import com.tutorial.loadbalancer.UserClient;
import com.tutorial.loadbalancer.kafka.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/get-user")
public class TestController {
    @Autowired
    private UserClient userClient;
    @Autowired
    private Sender sender;
    @Value("${spring.kafka.topic.userCreated}")
    private String USER_CREATED_TOPIC;

    @GetMapping
    public String testService(HttpServletRequest request) {
        System.out.println("I am " + request.getRequestURL().toString());
        String user = userClient.getUser(1L);
//        sender.send(USER_CREATED_TOPIC, "user payload");
        return user;
    }
}
