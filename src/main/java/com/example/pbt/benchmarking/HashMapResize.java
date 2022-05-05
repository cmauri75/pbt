package com.example.pbt.benchmarking;

import org.openjdk.jmh.annotations.*;

import java.util.HashMap;
import java.util.Map;

@State(Scope.Benchmark)
public class HashMapResize {

    @Param({"10", "14"})
    int keys;

    @Param({"16", "24"})
    int capacity;

    /**
     * 14/24 case is faster because of minor load factor. 10 case needs 10/0,75=14 rounded=16 size
     *
     * @return
     */
    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public Map<Integer, Integer> loadHashMap() {
        Map<Integer, Integer> map = new HashMap<>(capacity);
        for (int i = 0; i < keys; ++i)
            map.put(i, i);
        return map;
    }
}
