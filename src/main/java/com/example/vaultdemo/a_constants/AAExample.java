package com.example.vaultdemo.a_constants;

public class AAExample {

    public long computePrice(long purchasePriceInCents) {
        return (long) Math.nextUp(purchasePriceInCents * 1.10 * 1.21);
    }

}
