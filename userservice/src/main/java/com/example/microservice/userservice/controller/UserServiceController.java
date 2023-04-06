package com.example.microservice.userservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserServiceController {

    @GetMapping("/getUserDetailsById")
    public ResponseEntity<String> getUserDetailsById(@RequestParam String id){
        String returnObject ="{\"id\":\"001\",\"firstName\":\"John\",\"lastName\":\"Peter\",\"dob\":\"01/01/1990\",\"dept\":\"1\" }";

        return new ResponseEntity<String>(returnObject, HttpStatus.OK);
    }

    @GetMapping("/getUsersByDeptId")
    public ResponseEntity<String> getUsersByDeptId(@RequestParam String deptId){
        String returnObject ="[{\"id\":\"001\",\"firstName\":\"John\",\"lastName\":\"Peter\",\"dob\":\"01/01/1990\",\"dept\":\"1\" },"
                + " {\"id\":\"002\",\"firstName\":\"Ronald\",\"lastName\":\"Rich\",\"dob\":\"01/01/1980\",\"dept\":\"1\" },"
                + " {\"id\":\"003\",\"firstName\":\"Macy\",\"lastName\":\"Gordon\",\"dob\":\"11/01/1991\",\"dept\":\"1\" }]";

        return new ResponseEntity<String>(returnObject,HttpStatus.OK);
    }

}
