package com.example.vaultdemo.c_useage;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Data
@Component
@Profile("bcexample")
public class BCExample {

    @Value("${bc.financial.percentage.margin}") // No default value? Must be specified.
    private double marginPercentage; // value here - if present - is ignored

    @Value("${bc.financial.percentage.vatHigh:10.0}")
    private double vatHigh = 1.10;

    @Value("${some.other.prop}")
    private String tmp;

    private BCConfiguration config;

    public BCExample(BCConfiguration config) {
        this.config = config;
    }

    @PostConstruct
    public void afterStart() {
        System.out.println("Margin\n" +
                "\tFrom Value : " + marginPercentage + "\n" +
                "\tFrom Config: " + config.getMargin() + "\n" +
                "VAT High\n" +
                "\tFrom Value : " + vatHigh + "\n" +
                "\tFrom Config: " + config.getVatHigh()
                +"\nOther " + tmp
        );


    }
}

@Data
@Configuration
@ConfigurationProperties("bc.financial.percentage")
class BCConfiguration {
    private double margin = 1.10;
    private double vatHigh = 1.21;
}

//- prefer @ConfigurationProperties to @Value
//    - Eases testing
//            - easier property reuse
//            - more readable as related props are together
//            - Goes great with constructor injection!
//            - which is great with Lombok @AllArgsConstructo
//- Lombok instead of "generate getters and setters"
//        as that adds code without value, distracting from your unique contribution

// Command Line : mvn spring-boot:run
// Environment