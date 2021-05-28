package com.example.vaultdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// @SpringBootApplication
public class VaultdemoApplication {

    @Value("${mysecret1:defaultValue}")
    private String mysecret1;

    @Value("${mysecret2:defaultValue}")
    private String mysecret2;

    @Value("${mysecret3.username:defaultValue}")
    private String mysecret3;

    @Value("${mysecret4/password:defaultValue}")
    private String mysecret4;
	public static void main(String[] args) {
		SpringApplication.run(VaultdemoApplication.class, args);
	}


    @Bean
    public CommandLineRunner runner() {
        return args -> {
            System.out.println(
                    String.join(",", List.of(mysecret1, mysecret2, mysecret3, mysecret4))
            );
        };
    }
}
