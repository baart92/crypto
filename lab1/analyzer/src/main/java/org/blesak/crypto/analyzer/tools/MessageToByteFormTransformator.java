package org.blesak.crypto.analyzer.tools;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class MessageToByteFormTransformator {
    public Byte[] transform(File file, String charset) throws IOException {
        if (charset == null)
            return transform(file);

        String fileString = FileUtils.readFileToString(file, charset);
        return getBytes(fileString);
    }

    private Byte[] transform(File file) throws IOException {
        String fileString = FileUtils.readFileToString(file);
        return getBytes(fileString);
    }

    private Byte[] getBytes(String fileString) {
        String[] bytesInBinaryFormat = fileString.split(StringUtils.SPACE);

        List<Byte> bytesList = new LinkedList<Byte>();
        for (int i = 0; i < bytesInBinaryFormat.length; i++) {
            byte b = new BigInteger(bytesInBinaryFormat[i], 2).byteValue();
            bytesList.add(b);
        }
        return bytesList.toArray(new Byte[bytesList.size()]);
    }
}
