package org.pwr.crypto.vigenere;

import org.apache.commons.collections4.MapUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AttackManager {
    private ByteDataReceiver byteDataReceiver = new ByteDataReceiver();
    private RepeatSequencesLookup repeatSequencesLookup = new RepeatSequencesLookup();
    private FactorsProvider factorsProvider = new FactorsProvider();
    private OccurrenceHistogramCreator histogramCreator = new OccurrenceHistogramCreator();
    private KeyCharsPossibilitiesCounter possibilitiesCounter = new KeyCharsPossibilitiesCounter();
    private EncryptHandler eh = new EncryptHandler();

    public void perform(String filePath) throws IOException {
        System.out.println("Start attack...");

        Integer[] cipherText = byteDataReceiver.getByteArray(filePath);
        System.out.println("Ciphertext length: " + cipherText.length);

        System.out.println("Given ciphertext ASCII codes:");
        System.out.println(Arrays.toString(cipherText));

        System.out.println("Looking for repeated sequences of length 3...");
        System.out.println("Count of the spacing between the sequences:");
        List<Integer> spacings = repeatSequencesLookup.getSpacings(cipherText);
        System.out.println(spacings);

        System.out.println("Factors of each of these numbers:");
        List<Integer> factors = factorsProvider.updateListWithFactors(spacings);
        System.out.println(factors);

        System.out.println("Histogram of factors occurrence:");
        Map<Integer, Integer> histogram = histogramCreator.createHistogram(factors);
        MapUtils.debugPrint(System.out, "histogram", histogram);

        Integer theMostCommonCount = histogramCreator.getTheMostCommonCount();
        System.out.println("The most common count is: " + theMostCommonCount);

        System.out.println("Possible chars at key:");
        List<List<Integer>> prob = possibilitiesCounter.getProbableSignsOfKey(cipherText, theMostCommonCount);
        int counter = 0;
        for (List<Integer> list : prob) {
            System.out.println("Position " + ++counter + ": " + list);
        }

        System.out.println("Trying to break a key...");
        eh.tryToEncrypt(cipherText, prob, theMostCommonCount);
        System.out.println("Generated plaintexts saved to src/main/resources/out.txt");
    }
}
