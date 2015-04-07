package org.pwr.crypto.aes.dec;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

public class KeyExtractor {
    private KeyStore keystore;
    private KeyPair keyPair;
    private Key key;

    public KeyExtractor(String keyStorePath, char[] keyStorePassword, String keyAlias, char[] keyPassword) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {
        FileInputStream is = new FileInputStream(keyStorePath);
        this.keystore = KeyStore.getInstance("JCEKS");
        keystore.load(is, keyStorePassword);
        this.key = keystore.getKey(keyAlias, keyPassword);
    }

    public byte[] getEncodedPrivateKey() {
        return keyPair.getPrivate().getEncoded();
    }

    public Key getPrivateKey() {
        return key;
    }

}

