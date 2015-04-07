package org.pwr.crypto.aes.dec;

import org.apache.commons.io.FileUtils;

import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        String action = args[0];
        String keyStorePath = args[1];
        String keyAlias = args[2];
        char[] keyStorePassword = args[3].toCharArray();
        char[] keyPassword = args[4].toCharArray();
        File file = new File(args[5]);
        String mode = args[6];
        File outputFile = new File(args[7]);

        perform(action, keyStorePath, keyAlias, keyStorePassword, keyPassword, file, mode, outputFile);
    }

    public static void perform(String action, String keyStorePath, String keyAlias, char[] keyStorePassword, char[] keyPassword, File file, String mode, File outputFile) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        KeyExtractor keyExtractor = new KeyExtractor(keyStorePath, keyStorePassword, keyAlias, keyPassword);
        Key key = keyExtractor.getPrivateKey();

        if (action.equals("enc")) {
            EncryptProvider encryptProvider = new EncryptProvider();
            byte[] encryptedBytes = encryptProvider.encrypt(file, mode, key);
            FileUtils.writeByteArrayToFile(outputFile, encryptedBytes);
        } else if (action.equals("dec")) {
            DecryptProvider decryptProvider = new DecryptProvider();
            byte[] decryptedBytes = decryptProvider.decrypt(file, mode, key);
            FileUtils.writeByteArrayToFile(outputFile, decryptedBytes);
        }
    }

    public static void challenge(String keyStorePath, String keyAlias, char[] keyStorePassword, char[] keyPassword, File file1, File file2, String mode, File outputFile) throws UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        KeyExtractor keyExtractor = new KeyExtractor(keyStorePath, keyStorePassword, keyAlias, keyPassword);
        Key key = keyExtractor.getPrivateKey();

        Random r = new Random();
        EncryptProvider encryptProvider = new EncryptProvider();
        byte[] encryptedBytes = null;

        if(r.nextBoolean()){
            System.out.println("1");
            encryptedBytes = encryptProvider.encrypt(file1, mode, key);
        } else{
            System.out.println("2");
            encryptedBytes = encryptProvider.encrypt(file2, mode, key);
        }
        FileUtils.writeByteArrayToFile(outputFile, encryptedBytes);
    }
}
