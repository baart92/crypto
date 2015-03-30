package org.pwr.crypto.glibc;

import java.io.IOException;

/**
 * Based on:
 * http://www.mathstat.dal.ca/~selinger/random/
 */
public class Main {
    public static void main(String[] args) throws IOException {
        GlibcCracker cracker = new GlibcCracker();
        cracker.crack("src/main/resources/random");
    }
}
