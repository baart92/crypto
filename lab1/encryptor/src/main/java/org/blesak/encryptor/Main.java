package org.blesak.encryptor;

import org.blesak.encryptor.model.EncryptorDTO;
import org.blesak.encryptor.tools.ArgumentsValidator;
import org.blesak.encryptor.tools.EncryptProvider;

public class Main {
    public static void main(String[] args) {
        ArgumentsValidator validator = new ArgumentsValidator(args);
        EncryptorDTO encryptorDTO = validator.validate();
        EncryptProvider provider = new EncryptProvider(encryptorDTO);
        provider.perform();

    }
}
