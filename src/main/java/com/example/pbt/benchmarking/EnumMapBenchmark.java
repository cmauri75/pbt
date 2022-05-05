package com.example.pbt.benchmarking;

import org.apache.commons.math3.util.Pair;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;


public class EnumMapBenchmark {
  public enum Month {JAN,FEB,MAR,APR,MAJ,JUN,JUL,AGO,SEP,OCT,NOV,DEC}

  @State(Scope.Benchmark)
  public static abstract class BaseState {
    @Param("10000")
    int size;

    @Param("42")
    int seed;

    int[] randomValues;

    @Setup(Level.Trial)
    public void setup() {
      SplittableRandom random = new SplittableRandom(seed);
      randomValues = new int[size];
      for (int i = 0; i < size; i++)
        randomValues[i] = random.nextInt(0, Integer.MAX_VALUE);
      fill(randomValues);
    }

    abstract void fill(int[] randomValues);
  }

  @State(Scope.Benchmark)
  public static class EnumMapState extends BaseState {

    EnumMap<Month, String> map;
    Month[] values;

    @Override
    void fill(int[] randomValues) {
      map = new EnumMap<>(Month.class);
      values = new Month[randomValues.length];
      Month[] enumValues = Month.values();
      int pos = 0;
      for (int i : randomValues) {
        values[pos++] = enumValues[i % enumValues.length];
      }
      for (Month value : enumValues) {
        map.put(value, UUID.randomUUID().toString());
      }
    }
  }

  @State(Scope.Benchmark)
  public static class MixedState extends BaseState {

    EnumMap<Month, String> map;
    String[] values;

    @Override
    void fill(int[] randomValues) {
      map = new EnumMap<>(Month.class);
      values = new String[randomValues.length];
      Month[] enumValues = Month.values();
      int pos = 0;
      for (int i : randomValues) {
        values[pos++] = enumValues[i % enumValues.length].toString();
      }
      for (Month value : enumValues) {
        map.put(value, UUID.randomUUID().toString());
      }
    }
  }

  @State(Scope.Benchmark)
  public static class HashMapState extends BaseState {

    HashMap<String, String> map;
    String[] values;

    @Override
    void fill(int[] randomValues) {
      map = new HashMap<>();
      values = new String[randomValues.length];
      Month[] enumValues = Month.values();
      int pos = 0;
      for (int i : randomValues) {
        values[pos++] = enumValues[i % enumValues.length].toString();
      }
      for (Month value : enumValues) {
        map.put(value.toString(), UUID.randomUUID().toString());
      }
    }
  }

  @Benchmark
  @BenchmarkMode(Mode.SingleShotTime)
  public void enumMap(EnumMapState state, Blackhole bh) {
    for (Month value : state.values) {
      bh.consume(state.map.get(value));
    }
  }

  @Benchmark
  @BenchmarkMode(Mode.SingleShotTime)
  public void hashMap(HashMapState state, Blackhole bh) {
    for (String value : state.values) {
      bh.consume(state.map.get(value));
    }
  }
}
