package org.pwr.crypto.lcg;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class LcgCracker {
    public void crack(String path) throws IOException {
        InputExtractor extractor = new InputExtractor();
        List<BigInteger> integers = extractor.extract(path);
        System.out.println("Integers on input:");
        integers.forEach(System.out::println);

        DeterminantsCalculator determinantsCalculator = new DeterminantsCalculator();
        List<BigInteger> dets = determinantsCalculator.calculate(integers);
        System.out.println("Calculated determinants:");
        dets.forEach(System.out::println);

        GcdCalculator gcdCalculator = new GcdCalculator();
        BigInteger gcd = gcdCalculator.calculate(dets);
        System.out.println("Possible p: " + gcd);

        ModuloEquationsSolver solver = new ModuloEquationsSolver();
        solver.solve(integers, gcd);
    }
}
