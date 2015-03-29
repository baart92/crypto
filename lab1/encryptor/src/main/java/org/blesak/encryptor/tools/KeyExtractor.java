package org.blesak.encryptor.tools;

import org.blesak.encryptor.model.EncryptorDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class KeyExtractor {
    private KeyStore keystore;
    private KeyPair keyPair;

    public KeyExtractor(EncryptorDTO dto) throws UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        this(dto.getKeyStorePath(), dto.getKeyStorePassword(), dto.getKeyAlias(), dto.getKeyPassword());
    }

    private KeyExtractor(String keyStorePath, char[] keyStorePassword, String keyAlias, char[] keyPassword) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {
        FileInputStream is = new FileInputStream(keyStorePath);
        this.keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(is, keyStorePassword);
        Key key = keystore.getKey(keyAlias, keyPassword);
        if (key instanceof PrivateKey) {
            // Get certificate of public key
            Certificate cert = keystore.getCertificate(keyAlias);

            // Get public key
            PublicKey publicKey = cert.getPublicKey();

            // Return a key pair
            this.keyPair = new KeyPair(publicKey, (PrivateKey) key);
        }
    }

    public byte[] getEncodedPrivateKey() {
        return keyPair.getPrivate().getEncoded();
    }


}
