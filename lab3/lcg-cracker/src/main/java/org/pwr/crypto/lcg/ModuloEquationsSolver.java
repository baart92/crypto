package org.pwr.crypto.lcg;

import java.math.BigInteger;
import java.util.List;

public class ModuloEquationsSolver {
    public void solve(List<BigInteger> lists, BigInteger p) {
        BigInteger a1 = lists.get(0);
        BigInteger a2 = lists.get(1);
        BigInteger a3 = lists.get(2);

        System.out.println("Try to solve this linear modulo equations system:");
        System.out.println(a2.toString() + "\t = " + "a * " + a1.toString() + " + c (mod " + p.toString() + ")");
        System.out.println(a3.toString() + "\t = " + "a * " + a2.toString() + " + c (mod " + p.toString() + ")");
        System.out.println("for a, c.");

        System.out.println("It equals:");
        BigInteger A = a2.subtract(a3).mod(p);
        BigInteger B = a1.subtract(a2).mod(p);
        System.out.println(A.toString() + "\t = " + "a * " + B.toString() + " (mod " + p.toString() + ")");

        BigInteger[] bigIntegers = extendedEuclid(B, p);
        BigInteger a = A.multiply(bigIntegers[1]).mod(p);
        System.out.println("a = " + a);
        BigInteger c = a2.subtract(a.multiply(a1)).mod(p);
        System.out.println("c = " + c);

        System.out.println("Next 5 values:");
        int left = 5;
        BigInteger value = lists.get(lists.size() - 1);
        while (--left >= 0) {
            BigInteger nextValue = NextValuesGenerator.nextRandom(value, a, c, p);
            System.out.println(nextValue);
            value = nextValue;
        }
    }

    private static BigInteger[] extendedEuclid(BigInteger a, BigInteger b)
    /*  This function will perform the Extended Euclidean algorithm
        to find the GCD of a and b.  We assume here that a and b
        are non-negative (and not both zero).  This function also
        will return numbers j and k such that
               d = j*a + k*b
        where d is the GCD of a and b.
    */ {
        BigInteger[] ans = new BigInteger[3];
        BigInteger q;

        if (b.equals(BigInteger.ZERO)) {
            ans[0] = a;
            ans[1] = BigInteger.ONE;
            ans[2] = BigInteger.ZERO;
        } else {
            q = a.divide(b);
            ans = extendedEuclid(b, a.mod(b));
            BigInteger temp = ans[1].subtract(ans[2].multiply(q));
            ans[1] = ans[2];
            ans[2] = temp;
        }

        return ans;
    }
}
