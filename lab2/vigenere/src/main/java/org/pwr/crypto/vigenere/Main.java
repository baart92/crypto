package org.pwr.crypto.vigenere;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AttackManager am = new AttackManager();
        am.perform("src/main/resources/to_encrypt.cry");
    }
}
