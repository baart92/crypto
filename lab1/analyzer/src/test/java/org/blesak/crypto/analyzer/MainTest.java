package org.blesak.crypto.analyzer;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

public class MainTest {
    @Ignore
    @Test
    public void test() throws IOException {
        String[] args = new String[]{
                "src/test/resources/dec",
                "src/test/resources/to_decrypt.dec"
        };
        Main main = new Main();
        main.main(args);
    }
}
