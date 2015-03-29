package org.pwr.crypto.lcg;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.Validate;

import java.math.BigInteger;
import java.util.List;

public class DeterminantsCalculator {
    public List<BigInteger> calculate(List<BigInteger> random) {
        Validate.isTrue(random.size() > 2, "Number of inputs should be >= 3");

        List<BigInteger> output = Lists.newArrayList();
        for (int i = 1; i <= random.size() - 3; i++) {
            BigInteger det = calculateSingle(random, i, i + 1);
            output.add(det.abs());
        }
        return output;
    }

    private BigInteger calculateSingle(List<BigInteger> random, int i, int j) {
        BigInteger I = random.get(i);
        BigInteger I1 = random.get(i + 1);
        BigInteger J = random.get(j);
        BigInteger J1 = random.get(j + 1);
        BigInteger x1 = random.get(0);
        BigInteger x2 = random.get(1);
        return I.subtract(x1).multiply(J1.subtract(x2)).subtract(I1.subtract(x2).multiply(J.subtract(x1)));
        //return (I-x1)*(J1-x2)-(I1-x2)*(J-x1);
    }
}
