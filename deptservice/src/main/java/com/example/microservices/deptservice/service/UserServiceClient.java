package com.example.microservices.deptservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service")
public interface UserServiceClient {

    @GetMapping("/user/getUsersByDeptId")
    ResponseEntity<String> getUsersByDeptId(@RequestParam String deptId);

}
