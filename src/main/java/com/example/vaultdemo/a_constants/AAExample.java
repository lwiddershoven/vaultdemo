package com.example.vaultdemo.a_constants;

import java.math.BigDecimal;

public class AAExample {

    public long computePrice(long purchasePriceInCents) {
        return (long)Math.nextUp(purchasePriceInCents * 1.10 * 1.21);
    }

}
