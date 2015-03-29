package org.blesak.encryptor.algorithms;

import org.apache.commons.lang3.RandomUtils;
import org.bouncycastle.crypto.engines.Salsa20Engine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

import java.util.Arrays;

public class Salsa20Algorithm implements Algorithm {
    private final Salsa20Engine salsa20Engine;

    public Salsa20Algorithm() {
        this.salsa20Engine = new Salsa20Engine();
    }

    @Override
    public byte[] encode(byte[] key, byte[] message) {
        salsa20Engine.init(true, new ParametersWithIV(new KeyParameter(Arrays.copyOfRange(key, 0, 32)), RandomUtils.nextBytes(8)));
        byte[] encryptedBytes = new byte[message.length];
        salsa20Engine.processBytes(message, 0, message.length, encryptedBytes, 0);
        return encryptedBytes;
    }

    @Override
    public String getAlgorithmName() {
        return salsa20Engine.getAlgorithmName();
    }
}
