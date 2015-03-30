package org.pwr.crypto.glibc;

import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.Validate;

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
        Validate.isTrue(output.size() >= 32, "Input should contain at least 32 numbers");
        return output;
    }
}
