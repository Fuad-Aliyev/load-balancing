package com.tutorial.loadbalancer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service/user")
public interface UserClient {
    @GetMapping("/get/{id}")
    public String getUser(@PathVariable Long id);
}
