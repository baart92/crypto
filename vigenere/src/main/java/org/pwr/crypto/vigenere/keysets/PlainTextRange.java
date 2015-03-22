package org.pwr.crypto.vigenere.keysets;

public class PlainTextRange {
    private static final Integer SPACE_ASCII_CODE = 32;
    private static final Integer TILDE_ASCII_CODE = 126;

    public static boolean isInRange(Integer number) {
        return number >= SPACE_ASCII_CODE && TILDE_ASCII_CODE <= 126 ? true : false;
    }
}
