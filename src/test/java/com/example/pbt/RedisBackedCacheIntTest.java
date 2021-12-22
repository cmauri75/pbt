package com.example.pbt;

import com.example.pbt.Redis.Cache;
import com.example.pbt.Redis.RedisBackedCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Slf4j
@Testcontainers
public class RedisBackedCacheIntTest {

    @Container
    public GenericContainer redis = new GenericContainer(DockerImageName.parse("redis:5.0.3-alpine"))
            .withExposedPorts(6379);
    private Cache cache;

    @BeforeEach
    public void setUp() {
        log.info("Setting up");
        String address = redis.getHost();
        Integer port = redis.getFirstMappedPort();

        // Now we have an address and port for Redis, no matter where it is running
        cache = new RedisBackedCache(address, port, "testCache");
        log.info("cache is {}", cache);
    }

    @Test
    public void testSimplePutAndGet() {
        cache.put("test", "example");
        Optional<String> retrieved = cache.get("test", String.class);
        assertEquals("example", retrieved.get());
    }

    @Test
    public void testNotFindingAValueThatWasNotInserted() {
        Optional<String> foundObject = cache.get("bar", String.class);
        assertFalse(foundObject.isPresent());
    }
}