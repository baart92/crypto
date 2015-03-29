package org.blesak.encryptor.algorithms;

public class AlgorithmsList {
    public static final Algorithm[] ALGORITHMS = new Algorithm[]{
            new RC4Algorithm(),
            new Salsa20Algorithm(),
            new AESCTRAlgorithm()
    };
}
