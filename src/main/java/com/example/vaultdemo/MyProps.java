package com.example.vaultdemo;

import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties
public class MyProps {

    private String mysecret1;
    private String mysecret2;
    private Mysecret3 mysecret3;
    private Mysecret4 mysecret4;

    @Data
    static class Mysecret3 {
        private String username; // mysecret3.username
    }

    @Data
    static class Mysecret4 {
        private String password; // mysecret4/password not mapped as such
    }


    @Bean
    public CommandLineRunner runner2(MyProps props) {
        return args -> {
            System.out.println(props.toString());
        };
    }
}


