package com.example.pbt.benchmarking;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.annotations.*;
import redis.clients.jedis.util.Hashing;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class AnyClass {

    /**
     * Simple benchmark of a method
     * Use Mode.SingleShotTime to avoid very long testing
     */
    @Benchmark
    @Fork(value = 1, warmups = 0)
    @BenchmarkMode(Mode.SingleShotTime)
    public void init() {
        int i = 0;
        i++;
    }

    /**
     * Benchmarking method with multiple testcase
     */
    @State(Scope.Benchmark)
    public static class ExecutionPlan {

        @Param({"10", "100", "1000"})
        public int iterations;
        Hashing hasher;
        String password = "that's_password";

        @Setup(Level.Invocation)
        public void setUp() {
            //log.info("Setting up");
            hasher = Hashing.MURMUR_HASH;
        }
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @Warmup(iterations = 1)
    public void benchMurmur3_128(ExecutionPlan plan) {
        //log.info("Running with {} instances", plan.iterations);
        plan.hasher.hash(plan.password);
    }

}
