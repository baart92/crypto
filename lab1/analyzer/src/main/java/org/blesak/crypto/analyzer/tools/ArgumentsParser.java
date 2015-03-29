package org.blesak.crypto.analyzer.tools;

import org.apache.commons.lang3.Validate;
import org.blesak.crypto.analyzer.model.AnalyzerData;

public class ArgumentsParser {
    public AnalyzerData parse(String[] args) {
        Validate.isTrue(args.length >= 2);

        AnalyzerData data = new AnalyzerData();
        data.setDirWithCryptograms(args[0]);
        data.setCryptogramToDecipherPath(args[1]);

        if (args.length == 3) {
            data.setCharset(args[2]);
        }

        return data;
    }
}
