package org.pwr.crypto.lcg;

import java.io.IOException;

/**
 * Based on:
 * http://sandeepmore.com/blog/2012/03/23/breaking-linear-congruential-generator/
 * http://math.stackexchange.com/questions/203660/how-to-solve-system-of-equations-with-mod
 * https://cgi.csc.liv.ac.uk/~martin/teaching/comp202/Java/GCD.html
 */
public class Main {
    public static void main(String[] args) throws IOException {
        LcgCracker cracker = new LcgCracker();
        cracker.crack("src/main/resources/random.txt");
    }
}
