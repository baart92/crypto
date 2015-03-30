package org.pwr.crypto.glibc;

import java.math.BigInteger;
import java.util.List;

public class GlibcCalculator {
    public static final BigInteger POWER = BigInteger.valueOf(2L).pow(31);

    public void calculate(List<BigInteger> input, int howMany){
        int times = 0;
        while(++times <= howMany){
            int size = input.size();
            BigInteger newRandom = input.get(size - 31).add(input.get(size - 3)).mod(POWER);
            System.out.println(newRandom);
            input.add(newRandom);
        }
    }
}
