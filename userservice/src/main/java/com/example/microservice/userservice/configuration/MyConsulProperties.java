package com.example.microservice.userservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class MyConsulProperties {

    @Value("${teste}")
    private String teste1;

    @Value("${teste}")
    private String teste2;

    public String getTeste2() {
        return teste2;
    }

    public String getTeste1() {
        return teste1;
    }

}
