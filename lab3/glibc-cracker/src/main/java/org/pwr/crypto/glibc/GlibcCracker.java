package org.pwr.crypto.glibc;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class GlibcCracker {
    public void crack(String path) throws IOException {
        InputExtractor extractor = new InputExtractor();
        List<BigInteger> input = extractor.extract(path);
        System.out.println("Input is:");
        input.forEach(System.out::println);

        System.out.println("Next 16 numbers:");
        GlibcCalculator calculator = new GlibcCalculator();
        calculator.calculate(input, 16);
    }
}
