package org.pwr.crypto.lcg;

import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class InputExtractor {
    public List<BigInteger> extract(String path) throws IOException {
        File f = new File(path);
        List<String> strings = FileUtils.readLines(f);
        List<BigInteger> output = Lists.newArrayList();

        for (String string : strings) {
            output.add(new BigInteger(string));
        }

        return output;
    }
}
