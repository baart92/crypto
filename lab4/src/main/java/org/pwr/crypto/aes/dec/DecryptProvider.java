package org.pwr.crypto.aes.dec;

import org.apache.commons.io.IOUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class DecryptProvider {
    public byte[] decrypt(File ecryptedFile, String mode, Key key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(mode, new BouncyCastleProvider());
        IvParameterSpec ivParameterSpec = new IvParameterSpec(key.getEncoded());
        cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);

        byte[] fileBytes = IOUtils.toByteArray(new FileInputStream(ecryptedFile));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher);
        cipherOutputStream.write(fileBytes);
        cipherOutputStream.flush();
        cipherOutputStream.close();

        return outputStream.toByteArray();
    }
}
