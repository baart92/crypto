package org.blesak.encryptor.algorithms;

import org.bouncycastle.crypto.engines.RC4Engine;
import org.bouncycastle.crypto.params.KeyParameter;

public class RC4Algorithm implements Algorithm {
    private final RC4Engine rc4Engine;

    public RC4Algorithm() {
        this.rc4Engine = new RC4Engine();
    }

    @Override
    public byte[] encode(byte[] key, byte[] message) {
        rc4Engine.init(true, new KeyParameter(key));
        byte[] encryptedBytes = new byte[message.length];
        rc4Engine.processBytes(message, 0, message.length, encryptedBytes, 0);
        return encryptedBytes;
    }

    @Override
    public String getAlgorithmName() {
        return rc4Engine.getAlgorithmName();
    }
}
