package org.blesak.encryptor.tools;

import org.apache.commons.lang3.Validate;
import org.blesak.encryptor.model.EncryptorDTO;

public class ArgumentsValidator {
    private String[] args;

    public ArgumentsValidator(String[] args) {
        Validate.isTrue(args.length >= 5);
        this.args = args;
    }

    public EncryptorDTO validate() {
        EncryptorDTO dto = new EncryptorDTO();

        dto.setMessageFile(args[0]);
        dto.setKeyStorePath(args[1]);
        dto.setKeyStorePassword(args[2].toCharArray());
        dto.setKeyAlias(args[3]);
        dto.setKeyPassword(args[4].toCharArray());

        return dto;
    }
}
