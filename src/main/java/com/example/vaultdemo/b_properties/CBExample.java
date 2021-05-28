package com.example.vaultdemo.b_properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Component
public class CBExample {

    @Value("${financial.percentage.margin}")
    private double marginPercentage = 1.10;

    @Value("${financial.percentage.vat.high:1.21}") // with a default value
    private double vatHighPercentage = 1.21;

    public CBExample() {
        System.out.println("Margin percentage: " + marginPercentage + " vat " + vatHighPercentage); // what does this do?
    }

    public long computePrice(long purchasePriceInCents) {
        return (long)Math.nextUp(purchasePriceInCents * marginPercentage * vatHighPercentage);
    }

}
