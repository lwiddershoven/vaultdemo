package com.example.vaultdemo.c_useage;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile("bcvaultexample")
@Component
public class BCVaultExample {

    // Do not forget to check the properties file!

    @Value("${mysecret1:defaultValue}")
    private String mysecret1;

    @Value("${mysecret2:defaultValue}")
    private String mysecret2;

    @Value("${mysecret3.username:defaultValue}")
    private String mysecret3;

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            System.out.println("Values: " +
                    String.join(",", List.of(mysecret1, mysecret2, mysecret3))
            );
        };
    }
}

@Profile("bcvaultexample")
@Data
@Configuration
@ConfigurationProperties
class MyProps {

    private String mysecret1;
    private String mysecret2;
    private Mysecret3 mysecret3;

    @Data
    static class Mysecret3 {
        private String username; // mysecret3.username
        private String password; // mysecret3.password
    }

    @Bean
    public CommandLineRunner runner2(MyProps props) {
        return args -> {
            System.out.println("Properties: " + props.toString());
        };
    }
}