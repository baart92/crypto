package org.blesak.crypto.analyzer.cli;

import org.apache.commons.lang3.StringUtils;
import org.blesak.crypto.analyzer.tools.WordExplorer;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.Set;

public class ConsoleHelper {
    private Set<String> fileNames;
    private WordExplorer explorer;
    private Scanner sc = new Scanner(System.in);

    public ConsoleHelper(Set<String> fileNames, WordExplorer explorer) {
        this.fileNames = fileNames;
        this.explorer = explorer;
    }

    public void run() {
        showWelcomeMessage();
    }

    private void showWelcomeMessage() {
        System.out.println("Cryptogram file name available:");
        System.out.println(fileNames);
        System.out.println("Command format:");
        System.out.println("filename (all = for all)");
        System.out.println("word");
        System.out.println("charset name (def = default)");
        System.out.println(StringUtils.EMPTY);
        waitForCommands();
    }

    private void waitForCommands() {
        String fileName = sc.nextLine();
        String word = sc.nextLine();
        String charset = sc.nextLine();
        if (fileName.equals("all")) {
            for (String fName : fileNames) {
                System.out.println("For file: " + fName);
                performOneExplore(fName, word, charset);
            }
        } else {
            performOneExplore(fileName, word, charset);
        }
        waitForCommands();
    }

    private void performOneExplore(String fileName, String word, String charset) {
        try {
            explorer.explore(fileName, word, charset.equals("def") ? null : charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
