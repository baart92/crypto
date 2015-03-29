package org.blesak.encryptor.tools;

import org.apache.commons.io.FileUtils;
import org.blesak.encryptor.algorithms.Algorithm;
import org.blesak.encryptor.algorithms.AlgorithmsList;
import org.blesak.encryptor.model.EncryptorDTO;
import org.bouncycastle.util.encoders.Hex;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public class EncryptProvider {

    private final EncryptorDTO encryptorDTO;

    public EncryptProvider(EncryptorDTO encryptorDTO) {
        this.encryptorDTO = encryptorDTO;
    }

    public void perform() {
        try {
            byte[] key = getKey();
            FileUtils.write(new File("key.hex"), Hex.toHexString(key));
            byte[] message = Files.readAllBytes(Paths.get(encryptorDTO.getMessagePath()));
            CustomEncryptedDataWriter writer = new CustomEncryptedDataWriter();
            for (Algorithm algorithm : AlgorithmsList.ALGORITHMS) {
                byte[] encodedBytes = algorithm.encode(key, message);
                writer.save(encodedBytes, algorithm.getAlgorithmName() + ".dec");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

    private byte[] getKey() {
        KeyExtractor keyExtractor = null;
        try {
            keyExtractor = new KeyExtractor(encryptorDTO);
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return keyExtractor.getEncodedPrivateKey();
    }
}
