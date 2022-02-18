package com.example.pbt.redis;

import java.util.Optional;

public interface Cache {

    void put(String key, Object value);

    <T> Optional<T> get(String key, Class<T> expectedClass);
}