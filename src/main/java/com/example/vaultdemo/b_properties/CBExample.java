package com.example.vaultdemo.b_properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Profile("cbexample")
@Component
public class CBExample {

    @Value("${financial.percentage.margin:1.1}")
    private double marginPercentage; // value here does not matter

    @Value("${financial.percentage.vat.high:1.21}") // with a default value
    private double vatHighPercentage;

    public CBExample() {
        System.out.println("Constructor: Margin percentage: "
                + marginPercentage + " vat " + vatHighPercentage
        ); // what does this do?
    }

    @PostConstruct
    public void afterStart() {
        System.out.println("PostConstruct " + this);
    }

    public long computePrice(long purchasePriceInCents) {
        return (long)Math.nextUp(purchasePriceInCents * marginPercentage * vatHighPercentage);
    }

    @Override
    public String toString() {
        return "CBExample{" +
                "marginPercentage=" + marginPercentage +
                ", vatHighPercentage=" + vatHighPercentage +
                '}';
    }
}

@Profile("cbexample")
@Component
class CBPrintExample implements CommandLineRunner {

    @Autowired
    private CBExample cbExample;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("After start: " + cbExample);
    }
}
