package org.pwr.crypto.vigenere;

import com.google.common.collect.Maps;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.TreeBag;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OccurrenceHistogramCreator {
    private Map<Integer, Integer> map;

    public Map<Integer, Integer> createHistogram(List<Integer> data) {
        Bag<Integer> bag = new TreeBag<>();
        Map<Integer, Integer> result = Maps.newTreeMap();
        for (Integer integer : data) {
            bag.add(integer);
        }
        Set<Integer> uniqueFactors = bag.uniqueSet();
        for (Integer factor : uniqueFactors) {
            result.put(factor, bag.getCount(factor));
        }
        this.map = result;
        return result;
    }

    public Integer getTheMostCommonCount() {
        int max = 0;
        int number = 0;
        Set<Integer> integers = map.keySet();
        for (Integer i : integers) {
            if (map.get(i) > max) {
                max = map.get(i);
                number = i;
            }
        }
        return number;
    }
}
