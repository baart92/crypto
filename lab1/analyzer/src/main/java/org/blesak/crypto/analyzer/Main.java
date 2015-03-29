package org.blesak.crypto.analyzer;

import org.blesak.crypto.analyzer.cli.ConsoleHelper;
import org.blesak.crypto.analyzer.tools.Analyzer;
import org.blesak.crypto.analyzer.tools.WordExplorer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Analyzer analyzer = new Analyzer();
        analyzer.analyze(args);

        WordExplorer wordExplorer = new WordExplorer(analyzer.getMap(), analyzer.getBytesToEncrypt());
        ConsoleHelper helper = new ConsoleHelper(analyzer.getMap().keySet(), wordExplorer);
        helper.run();
    }
}
