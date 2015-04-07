package org.pwr.crypto.aes.dec;

import org.junit.Test;

import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

public class ChallengeTest extends OracleAccessTest {
    @Test
    public void shouldEncryptAndDecryptWithCbcMode() throws Exception {
        // given
        String file1 = PATH + "jawny1.txt";
        String file2 = PATH + "jawny2.txt";
        String output = PATH + "challange.txt";
        // when then
        this.challenge(file1, file2, output, MODE_CBC);
    }

    protected void challenge(String file1, String file2, String output, String mode) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, IOException, KeyStoreException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        Main.challenge(KEY_STORE, KEY_ALIAS, KS_PASS, KEY_PASS, new File(file1), new File(file2), mode, new File(output));
    }
}
