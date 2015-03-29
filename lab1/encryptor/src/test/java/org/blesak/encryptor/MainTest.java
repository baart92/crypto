package org.blesak.encryptor;

import org.junit.Test;

public class MainTest {
    @Test
    public void test() {
        String[] args = new String[]{
                "src/test/resources/message.txt",
                "src/test/resources/keystore2.jks",
                "password",
                "crypto",
                "password"
        };
        Main main = new Main();
        main.main(args);
    }
}
