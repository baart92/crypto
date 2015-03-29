package org.pwr.crypto.vigenere;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

public class ByteDataReceiver {
    public Integer[] getByteArray(String filePath) throws IOException {
        String fileString = FileUtils.readFileToString(new File(filePath));
        String[] splittedString = fileString.split(StringUtils.SPACE);

        Integer[] result = new Integer[splittedString.length];
        for (int i = 0; i < result.length; i++) {
            if (i == result.length - 1) {
                result[i] = new BigInteger(splittedString[i].substring(0, 2), 16).intValue();
            } else {
                result[i] = new BigInteger(splittedString[i], 16).intValue();
            }
        }
        return result;
    }
}
