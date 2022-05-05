package com.example.pbt;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class BenchmarkingTests {

    @Test
    void runBenchs() throws IOException {
        org.openjdk.jmh.Main.main(new String[]{""});
    }

}
