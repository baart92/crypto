package org.pwr.crypto.vigenere;

import org.apache.commons.io.FileUtils;
import org.pwr.crypto.vigenere.keysets.KeyRange;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EncryptHandler {
    private static List<String> lines;

    static {
        try {
            lines = FileUtils.readLines(new File("src/main/resources/slownik.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tryToEncrypt(Integer[] data, List<List<Integer>> prob, Integer theMostCommonCount) throws IOException {
        System.out.println("Dictionary size: " + lines.size());
        for (String word : lines) {
            if (word.length() != theMostCommonCount)
                continue;
            String processedWord = processWord(word, prob);
            Integer[] wordArray = wordArray(processedWord);

            Integer[] result = new Integer[data.length];
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                Integer xor = data[i] ^ wordArray[i % wordArray.length];
                sb.append(Character.toChars(xor));
            }
            FileUtils.writeStringToFile(new File("src/main/resources/out.txt"), processedWord + " | " + sb.toString(), true);
        }
    }

    private String processWord(String word, List<List<Integer>> prob) {
        String output = word;
        int counter = 0;
        for (List<Integer> allowLetters : prob) {
            if (allowLetters.equals(KeyRange.SMALL_LETTERS)) {
                StringBuilder sb = new StringBuilder(output);
                sb.setCharAt(counter, Character.toLowerCase(output.charAt(counter)));
                output = sb.toString();
            } else if (allowLetters.equals(KeyRange.LARGE_LETTERS)) {
                StringBuilder sb = new StringBuilder(output);
                sb.setCharAt(counter, Character.toUpperCase(output.charAt(counter)));
                output = sb.toString();
            }
            counter++;
        }
        return output;
    }

    private Integer[] wordArray(String processedWord) {
        Integer[] result = new Integer[processedWord.length()];
        for (int i = 0; i < processedWord.length(); i++) {
            result[i] = (int) processedWord.charAt(i);
        }
        return result;
    }

}
