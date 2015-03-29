package org.pwr.crypto.lcg;

import com.google.common.collect.Iterables;

import java.math.BigInteger;
import java.util.List;

public class GcdCalculator {
    public BigInteger calculate(List<BigInteger> integers) {
        while (integers.size() > 1) {
            BigInteger a = integers.get(0);
            BigInteger b = integers.get(1);
            BigInteger gcd = a.gcd(b);
            integers.remove(1);
            integers.set(0, gcd);
        }
        return Iterables.getFirst(integers, BigInteger.ZERO);
    }
}
