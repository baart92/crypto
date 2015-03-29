package org.blesak.encryptor.algorithms;

import org.apache.commons.lang3.RandomUtils;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.SICBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

import java.util.Arrays;

public class AESCTRAlgorithm implements Algorithm {
    private final SICBlockCipher sicBlockCipher;

    public AESCTRAlgorithm() {
        this.sicBlockCipher = new SICBlockCipher(new AESEngine());
    }

    @Override
    public byte[] encode(byte[] key, byte[] message) {
        sicBlockCipher.init(true, new ParametersWithIV(new KeyParameter(Arrays.copyOfRange(key, 0, 32)), RandomUtils.nextBytes(16)));
        byte[] encryptedBytes = new byte[message.length];
        sicBlockCipher.processBytes(message, 0, message.length, encryptedBytes, 0);
        return encryptedBytes;
    }

    @Override
    public String getAlgorithmName() {
        return sicBlockCipher.getAlgorithmName().replace("/", "_");
    }
}
