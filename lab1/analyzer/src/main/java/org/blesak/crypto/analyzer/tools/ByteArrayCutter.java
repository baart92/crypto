package org.blesak.crypto.analyzer.tools;

import java.util.*;

public class ByteArrayCutter {
    private int min;

    public Map<String, Byte[]> cut(Map<String, Byte[]> map) {
        Collection<Byte[]> bytesCollection = map.values();
        int min = Integer.MAX_VALUE;
        for (Byte[] bytes : bytesCollection) {
            if (bytes.length < min) {
                min = bytes.length;
            }
        }
        this.min = min;
        return cutOff(map, min);
    }

    private Map<String, Byte[]> cutOff(Map<String, Byte[]> map, int min) {
        Set<String> keySet = map.keySet();
        Map<String, Byte[]> newMap = new HashMap<String, Byte[]>();
        for (String key : keySet) {
            Byte[] bytes = map.get(key);
            if (bytes.length > min) {
                newMap.put(key, Arrays.copyOfRange(bytes, 0, min));
            } else {
                newMap.put(key, bytes);
            }
        }
        return newMap;
    }

    public Byte[] cutOff(Byte[] bytes) {
        return Arrays.copyOfRange(bytes, 0, min);
    }
}
