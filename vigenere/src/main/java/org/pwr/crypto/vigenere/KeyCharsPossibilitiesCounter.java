package org.pwr.crypto.vigenere;

import com.google.common.collect.Lists;
import org.pwr.crypto.vigenere.keysets.KeyRange;
import org.pwr.crypto.vigenere.keysets.PlainTextRange;

import java.util.List;

public class KeyCharsPossibilitiesCounter {
    public List<List<Integer>> getProbableSignsOfKey(Integer[] data, Integer keyLength) {
        List<List<Integer>> result = Lists.newArrayList();
        for (int pos = 0; pos < keyLength; pos++) {
            List<Integer> subResult = performOne(data, keyLength, pos);
            result.add(subResult);
        }
        return result;
    }

    private List<Integer> performOne(Integer[] data, Integer keyLength, Integer position) {
        List<Integer> result = Lists.newArrayList();
        for (Integer keyChar : KeyRange.ASCII_CODES) {
            boolean flag = true;
            for (int j = position; j < data.length; j += keyLength) {
                Integer xored = data[j] ^ keyChar;
                if (!PlainTextRange.isInRange(xored)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(keyChar);
            }
        }
        return result;
    }
}
