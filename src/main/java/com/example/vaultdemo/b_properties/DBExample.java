package com.example.vaultdemo.b_properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dbexample")
@Component
public class DBExample {
    private DBConfiguration config;

    public DBExample(DBConfiguration config) {
        this.config = config;
        System.out.println("Margin percentage: " + config.getMargin() + " vat " + config.getVatHigh());
    }

    public long computePrice(long purchasePriceInCents) {
        return (long) Math.nextUp(purchasePriceInCents * config.getMargin() * config.getVatHigh());
    }

}


// This tends to be what Spring Boot uses internally
// Plus things like ConditionalOnProperty, ConditionalOnMissingBean
@Data
@Configuration
@ConfigurationProperties("db.financial.percentage")
class DBConfiguration {
    private double margin = 1.10;
    private double vatHigh = 1.21;
}
