package com.example.pbt;

import com.example.pbt.ehcache.EHCacheManager;
import com.example.pbt.support.SimpleTimer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EhCacheTest {

    private final static int dbSize = 3 * 1000 * 100;

    @Autowired
    SimpleTimer timer;

    @Autowired
    EHCacheManager cacheManager;

    @BeforeAll
    public void prepareData() {
        timer.start();
        for (int i = 0; i <= dbSize; i++) {
            cacheManager.saveValue(i, String.valueOf(i));
        }
        timer.end("Creating data");
    }

    @Test
    public void testSimple() {
        cacheManager.saveValue(1, "ciao");
        Assertions.assertEquals("ciao", cacheManager.getText(1));
    }

    @Test
    public void TreeHundredTest() {
        Assertions.assertEquals("0", cacheManager.getText(0));
        Assertions.assertEquals(String.valueOf(dbSize), cacheManager.getText(dbSize));
    }

    @Test
    public void testQuery() {
        cacheManager.saveValue(1, "ciao");
        cacheManager.saveValue(2, "ciao2");
        Assertions.assertEquals("ciao2", cacheManager.getText(2));
    }

    @Test
    public void testBigQuery() {
        int expRes = dbSize / 100;
        timer.start();
        Assertions.assertEquals(2, cacheManager.queryText("Cia*").size());
        Assertions.assertEquals(2, cacheManager.queryText("*I*").size());
        Assertions.assertEquals(12, cacheManager.queryText(expRes+"*").size());
        Assertions.assertEquals(100, cacheManager.queryText("*").size());
        timer.end("double search");
    }

}
