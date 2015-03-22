package org.pwr.crypto.vigenere;

import com.google.common.collect.Lists;

import java.util.List;

public class RepeatSequencesLookup {

    public List<Integer> getSpacings(Integer[] data) {
        List<Integer> result = Lists.newArrayList();

        for (int i = 0; i < data.length - 2; i++) {
            Triple triple = new Triple(data, i);
            List<Integer> found = Lists.newArrayList();
            for (int j = 0; j < data.length - 2; j++) {
                Triple secondTriple = new Triple(data, j);
                if (triple.equals(secondTriple)) {
                    found.add(j);
                    if (found.size() > 1) {
                        for (Integer pos : found) {
                            if (pos == j)
                                continue;
                            result.add(Math.abs(pos - j));
                        }
                    }
                }
            }
        }
        return result;
    }

    class Triple {
        private final Integer a;
        private final Integer b;
        private final Integer c;

        public Triple(Integer[] data, Integer startIndex) {
            this.a = data[startIndex];
            this.b = data[startIndex + 1];
            this.c = data[startIndex + 2];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Triple)) return false;

            Triple triple = (Triple) o;

            if (a != null ? !a.equals(triple.a) : triple.a != null) return false;
            if (b != null ? !b.equals(triple.b) : triple.b != null) return false;
            if (c != null ? !c.equals(triple.c) : triple.c != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = a != null ? a.hashCode() : 0;
            result = 31 * result + (b != null ? b.hashCode() : 0);
            result = 31 * result + (c != null ? c.hashCode() : 0);
            return result;
        }
    }
}
