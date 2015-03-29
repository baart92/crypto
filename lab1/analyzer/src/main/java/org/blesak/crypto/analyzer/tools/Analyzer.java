package org.blesak.crypto.analyzer.tools;

import org.blesak.crypto.analyzer.model.AnalyzerData;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analyzer {
    private Map<String, Byte[]> map = new HashMap<String, Byte[]>();
    private Byte[] bytesToEncrypt;

    public void analyze(String[] args) throws IOException {
        ArgumentsParser parser = new ArgumentsParser();
        AnalyzerData analyzerData = parser.parse(args);

        CipherFilesExtractor extractor = new CipherFilesExtractor();
        List<File> files = extractor.getFiles(analyzerData.getDirWithCryptograms());

        MessageToByteFormTransformator transformator = new MessageToByteFormTransformator();
        for (File file : files) {
            Byte[] byteArrayForm = transformator.transform(file, analyzerData.getCharset());
            map.put(file.getName(), byteArrayForm);
        }
        ByteArrayCutter cutter = new ByteArrayCutter();
        map = cutter.cut(map);

        File fileToEncrypt = new File(analyzerData.getCryptogramToDecipherPath());
        Byte[] byteArrayFormEncrypt = transformator.transform(fileToEncrypt, analyzerData.getCharset());
        bytesToEncrypt = cutter.cutOff(byteArrayFormEncrypt);
    }

    public Map<String, Byte[]> getMap() {
        return map;
    }

    public Byte[] getBytesToEncrypt() {
        return bytesToEncrypt;
    }
}
