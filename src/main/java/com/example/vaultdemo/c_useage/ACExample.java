package com.example.vaultdemo.c_useage;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Profile("acexample")
@Component
public class ACExample {

    @Value("${acexample.value1:test}")
    private String value1;

    @Value("${acexample.test.value:test}")
    private String value2;

    @Autowired
    private ACConfig config;

    @PostConstruct
    public void showValues() {
        System.out.println(
           "@Value value1            : " + value1 + "\n" +
           "@Value value2            : " + value2 + "\n" +
           "@ConfigurationProperties : " + config
        );
    }
}

@Data // getters, setters
@Profile("acexample")
@Configuration
@ConfigurationProperties("acexample")
class ACConfig {
    private String value1;
    private String otherValue = "1234";
    private Inner test= new Inner();

    @Data
    static class Inner {
        private String value = "bla2";
    }
}