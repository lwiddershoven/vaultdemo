package com.example.vaultdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "cbexample");
//        System.setProperty("spring.profiles.active", "dbexample");
//        System.setProperty("spring.profiles.active", "acexample");
//        System.setProperty("spring.profiles.active", "bcvaultexample");
        SpringApplication.run(DemoApplication.class);
    }
}
