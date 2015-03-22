package org.pwr.crypto.vigenere;

import com.google.common.collect.Lists;

import java.util.List;

public class FactorsProvider {
    public List<Integer> updateListWithFactors(List<Integer> data) {
        List<Integer> result = Lists.newArrayList();

        for (Integer integer : data) {
            List<Integer> factors = getFactors(integer);
            result.addAll(factors);
        }

        return result;
    }

    private List<Integer> getFactors(int n) {
        List<Integer> result = Lists.newArrayList();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
