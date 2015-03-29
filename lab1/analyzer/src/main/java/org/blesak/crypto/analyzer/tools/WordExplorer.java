package org.blesak.crypto.analyzer.tools;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;

public final class WordExplorer {
    private final Map<String, Byte[]> map;
    private final Byte[] bytesToEncode;

    public WordExplorer(Map<String, Byte[]> map, Byte[] bytesToEncode) {
        this.map = map;
        this.bytesToEncode = bytesToEncode;
    }

    public void explore(String cryptogramFileName, String word, String charset) throws UnsupportedEncodingException {
        Byte[] msgXor = xor(cryptogramFileName);
        byte[] wordBytes = null;
        if (charset == null) {
            wordBytes = word.getBytes();
        } else {
            wordBytes = word.getBytes(charset);
        }
        Byte[] wordBytesObj = ArrayUtils.toObject(wordBytes);
        for (int start = 0; start <= msgXor.length - wordBytesObj.length; start++) {
            Byte[] subMsgXor = Arrays.copyOfRange(msgXor, start, start + wordBytesObj.length);
            Validate.isTrue(subMsgXor.length == wordBytesObj.length);
            Byte[] result = xor(subMsgXor, wordBytesObj);
            String stringResult = null;
            if (charset == null) {
                stringResult = new String(ArrayUtils.toPrimitive(result));
            } else {
                stringResult = new String(ArrayUtils.toPrimitive(result), charset);
            }
            System.out.println(start + " : \t" + stringResult);
        }
    }

    private Byte[] xor(String cryptogramFileName) {
        Byte[] c = map.get(cryptogramFileName);
        Validate.isTrue(c.length == bytesToEncode.length);
        Byte[] result = new Byte[c.length];


        for (int i = 0; i < c.length; i++) {
            byte a = c[i];
            byte b = bytesToEncode[i];
            result[i] = (byte) (((int) a) ^ ((int) b));
        }
        return result;
    }

    private Byte[] xor(Byte[] a, Byte[] b) {
        Byte[] result = new Byte[Math.min(a.length, b.length)];

        for (int i = 0; i < result.length; i++) {
            result[i] = (byte) (((int) a[i]) ^ ((int) b[i]));
        }
        return result;
    }
}
