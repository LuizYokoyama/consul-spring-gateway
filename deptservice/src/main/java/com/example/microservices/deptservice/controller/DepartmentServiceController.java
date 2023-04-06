package com.example.microservices.deptservice.controller;

import com.example.microservices.deptservice.service.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentServiceController {

    @Autowired
    UserServiceClient userServiceClient;

    @GetMapping("/getDepartmentDetailsById")
    public ResponseEntity<String> getDepartmentDetailsById(@RequestParam String id){
        String returnObject ="{\"deptId\":\"1\",\"name\":\"Security\"}";

        return new ResponseEntity<String>(returnObject, HttpStatus.OK);
    }

    @GetMapping("/getUsersByDeptId")
    public ResponseEntity<String> getUsersByDeptId(@RequestParam String deptId){
        return userServiceClient.getUsersByDeptId(deptId);
    }

}
