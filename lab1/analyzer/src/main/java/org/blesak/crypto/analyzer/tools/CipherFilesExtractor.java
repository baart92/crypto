package org.blesak.crypto.analyzer.tools;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CipherFilesExtractor {
    public List<File> getFiles(String path) {
        Collection<File> files = FileUtils.listFiles(new File(path), new String[]{"dec"}, false);
        return new ArrayList<File>(files);
    }
}
