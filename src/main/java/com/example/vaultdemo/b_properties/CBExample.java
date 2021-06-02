package com.example.vaultdemo.b_properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("cbexample")
@Component
public class CBExample {

    @Value("${financial.percentage.margin}")
    private double marginPercentage; // value here does not matter

    @Value("${financial.percentage.vat.high:1.21}") // with a default value
    private double vatHighPercentage;

    public CBExample() {
        System.out.println("Margin percentage: "
                + marginPercentage + " vat " + vatHighPercentage
        ); // what does this do?
    }

    public long computePrice(long purchasePriceInCents) {
        return (long)Math.nextUp(purchasePriceInCents * marginPercentage * vatHighPercentage);
    }

}
