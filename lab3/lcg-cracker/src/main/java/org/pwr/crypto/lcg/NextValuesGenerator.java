package org.pwr.crypto.lcg;

import java.math.BigInteger;

public class NextValuesGenerator {
    public static BigInteger nextRandom(BigInteger value, BigInteger a, BigInteger c, BigInteger p) {
        return a.multiply(value).add(c).mod(p);
    }
}
