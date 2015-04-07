package org.pwr.crypto.aes.dec;

import org.junit.Test;

import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

public class OracleAccessTest {
    public static final String ACTION_ENC = "enc";
    public static final String ACTION_DEC = "dec";
    public static final String KEY_STORE = "src/test/resources/omc.ks";
    public static final String KEY_ALIAS = "omc";
    public static final char[] KS_PASS = "omcomc".toCharArray();
    public static final char[] KEY_PASS = "omcomc".toCharArray();
    public static final String PATH = "src/test/resources/";

    public static final String MODE_CBC = "AES/CBC/PKCS5Padding";
    public static final String MODE_CTR = "AES/CTR/NoPadding";
    public static final String MODE_OFB = "AES/OFB/NoPadding";

    @Test
    public void shouldEncryptAndDecryptWithCbcMode() throws Exception {
        // given
        String file = PATH + "jawny1.txt";
        String encFile = PATH + "jawny1_cbc_enc.txt";
        String decEncFile = PATH + "jawny1_cbc_dec.txt";

        // when then
        this.perform(ACTION_ENC, file, encFile, MODE_CBC);
        this.perform(ACTION_DEC, encFile, decEncFile, MODE_CBC);
    }

    @Test
    public void shouldEncryptAndDecryptWithCtrMode() throws Exception {
        // given
        String file = PATH + "jawny1.txt";
        String encFile = PATH + "jawny1_ctr_enc.txt";
        String decEncFile = PATH + "jawny1_ctr_dec.txt";

        // when then
        this.perform(ACTION_ENC, file, encFile, MODE_CTR);
        this.perform(ACTION_DEC, encFile, decEncFile, MODE_CTR);
    }

    @Test
    public void shouldEncryptAndDecryptWithOfbMode() throws Exception {
        // given
        String file = PATH + "jawny1.txt";
        String encFile = PATH + "jawny1_ofb_enc.txt";
        String decEncFile = PATH + "jawny1_ofb_dec.txt";

        // when then
        this.perform(ACTION_ENC, file, encFile, MODE_OFB);
        this.perform(ACTION_DEC, encFile, decEncFile, MODE_OFB);
    }

    protected void perform(String action, String input, String output, String mode) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, IOException, KeyStoreException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        Main.perform(action, KEY_STORE, KEY_ALIAS, KS_PASS, KEY_PASS, new File(input), mode, new File(output));
    }
}
