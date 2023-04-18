package com.example.microservice.userservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
@ConfigurationProperties("teste.properties")
public class MyConsulProperties {

    private String teste;

    public String getProp() {
        return teste;
    }

    public void setProp(String prop) {
        this.teste = prop;
    }
}
