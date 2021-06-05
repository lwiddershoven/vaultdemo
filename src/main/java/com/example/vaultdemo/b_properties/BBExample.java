package com.example.vaultdemo.b_properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("bbexample")
@Component  // => bean; managed by spring
public class BBExample {

    @Value("${financial.percentage.margin}") // SPeL : ${}
    private double marginPercentage;
//  public static final double MARGIN_PERCENTAGE = 1.10;

    @Value("${financial.percentage.vat.high:1.21}") // with a default value
    private double vatHighPercentage;

    public long computePrice(long purchasePriceInCents) {
        return (long)Math.nextUp(purchasePriceInCents * marginPercentage * vatHighPercentage);
    }

}
