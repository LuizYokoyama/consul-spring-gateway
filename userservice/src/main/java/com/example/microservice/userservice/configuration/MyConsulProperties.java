package com.example.microservice.userservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
@ConfigurationProperties("teste")
public class MyConsulProperties {

    @Value("${teste1}")
    private String teste1;

    @Value("${teste.teste2}")
    private String teste2;

    public void setTeste1(String teste1) {
        this.teste1 = teste1;
    }

    public void setTeste2(String teste2) {
        this.teste2 = teste2;
    }

    public String getTeste2() {
        return teste2;
    }

    public String getTeste1() {
        return teste1;
    }

}
