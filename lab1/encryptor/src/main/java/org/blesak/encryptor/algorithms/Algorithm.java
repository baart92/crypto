package org.blesak.encryptor.algorithms;

public interface Algorithm {
    byte[] encode(byte[] key, byte[] message);

    String getAlgorithmName();
}
