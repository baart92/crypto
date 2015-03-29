package org.blesak.encryptor.tools;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class CustomEncryptedDataWriter {
    public void save(byte[] encryptedBytes, String filePath) throws IOException {
        File outputFile = new File(filePath);
        for (int i = 0; i < encryptedBytes.length; i++) {
            byte oneByte = encryptedBytes[i];
            String byteInStringFormat = String.format("%8s", Integer.toBinaryString(oneByte & 0xFF)).replace(' ', '0');
            FileUtils.write(outputFile, byteInStringFormat + StringUtils.SPACE, Charset.defaultCharset(), true);
        }
    }
}
