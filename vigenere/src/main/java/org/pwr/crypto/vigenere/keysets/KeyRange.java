package org.pwr.crypto.vigenere.keysets;

import com.google.common.collect.Lists;

import java.util.List;

/* 0, ..., 9, a, ..., z, A, ..., Z */
public class KeyRange {
    public static List<Integer> ASCII_CODES = Lists.newArrayList(48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71,
            72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102,
            103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122);

    public static List<Integer> SMALL_LETTERS = Lists.newArrayList(97, 98, 99, 100, 101, 102, 103, 104, 105, 106,
            107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122);

    public static List<Integer> LARGE_LETTERS = Lists.newArrayList(65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77,
            78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90);
}
