package com.example.microservices.organizationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organization")
public class OrgServiceController {

    @GetMapping("/details")
    public ResponseEntity<String> getDetails(){
        String returnObject ="organization details test";

        return new ResponseEntity<String>(returnObject, HttpStatus.OK);
    }

}
