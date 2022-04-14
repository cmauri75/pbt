package com.example.pbt;

import com.example.pbt.ehcache.EHCacheManager;
import com.example.pbt.support.SimpleTimer;
import org.junit.jupiter.api.*;
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

    @AfterAll
    public void clearData() {
        cacheManager.clear();
    }

    @Test
    public void testSimple() {
        Integer key = Integer.MAX_VALUE;
        cacheManager.saveValue(key, "ciao");
        Assertions.assertEquals("ciao", cacheManager.getText(key));
        cacheManager.removeValue(key);
    }

    @Test
    public void TreeHundredTest() {
        prepareData();

        Assertions.assertEquals("0", cacheManager.getText(0));
        Assertions.assertEquals(String.valueOf(dbSize), cacheManager.getText(dbSize));
    }

    @Test
    public void testQuery() {
        Integer key1 = Integer.MAX_VALUE;
        Integer key2 = Integer.MAX_VALUE - 1;

        cacheManager.saveValue(key1, "ciao");
        cacheManager.saveValue(key2, "ciao2");
        Assertions.assertEquals("ciao2", cacheManager.getText(key2));
        cacheManager.removeValue(key1, key2);
    }

    @Test
    public void testBigQuery() {
        int expRes = dbSize / 100;
        timer.start();
        Assertions.assertEquals(0, cacheManager.queryText("Cia*").size());
        Assertions.assertEquals(0, cacheManager.queryText("*I*").size());
        Assertions.assertEquals(12, cacheManager.queryText(expRes + "*").size());
        Assertions.assertEquals(100, cacheManager.queryText("*").size());
        timer.end("double search");
    }

}
