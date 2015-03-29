package org.blesak.crypto.analyzer.model;

public class AnalyzerData {
    private String dirWithCryptograms;
    private String cryptogramToDecipherPath;
    private String charset;

    public String getDirWithCryptograms() {
        return dirWithCryptograms;
    }

    public void setDirWithCryptograms(String dirWithCryptograms) {
        this.dirWithCryptograms = dirWithCryptograms;
    }

    public String getCryptogramToDecipherPath() {
        return cryptogramToDecipherPath;
    }

    public void setCryptogramToDecipherPath(String cryptogramToDecipherPath) {
        this.cryptogramToDecipherPath = cryptogramToDecipherPath;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }
}
