package org.blesak.encryptor.model;

public class EncryptorDTO {
    private String messagePath;
    private String keyStorePath;
    private char[] keyStorePassword;
    private String keyAlias;
    private char[] keyPassword;

    public String getMessagePath() {
        return messagePath;
    }

    public void setMessageFile(String messagePath) {
        this.messagePath = messagePath;
    }

    public String getKeyStorePath() {
        return keyStorePath;
    }

    public void setKeyStorePath(String keyStorePath) {
        this.keyStorePath = keyStorePath;
    }

    public char[] getKeyStorePassword() {
        return keyStorePassword;
    }

    public void setKeyStorePassword(char[] keyStorePassword) {
        this.keyStorePassword = keyStorePassword;
    }

    public String getKeyAlias() {
        return keyAlias;
    }

    public void setKeyAlias(String keyAlias) {
        this.keyAlias = keyAlias;
    }

    public char[] getKeyPassword() {
        return keyPassword;
    }

    public void setKeyPassword(char[] keyPassword) {
        this.keyPassword = keyPassword;
    }
}
