package com.example.vaultdemo.a_constants;

public class BAExample {


    public static final double MARGIN_PERCENTAGE = 1.10;
    public static final double VAT_HIGH_PERCENTAGE = 1.21;

    public long computePrice(long purchasePriceInCents) {
        return (long)Math.nextUp(purchasePriceInCents * MARGIN_PERCENTAGE * VAT_HIGH_PERCENTAGE);
    }

}
