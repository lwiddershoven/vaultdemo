package com.example.vaultdemo.b_properties;

import org.springframework.stereotype.Component;

// @Component
public class ABExample {

    public static final double MARGIN_PERCENTAGE = 1.10;
    public static final double VAT_HIGH_PERCENTAGE = 1.21;

    public long computePrice(long purchasePriceInCents) {
        return (long)Math.nextUp(purchasePriceInCents * MARGIN_PERCENTAGE * VAT_HIGH_PERCENTAGE);
    }

}
