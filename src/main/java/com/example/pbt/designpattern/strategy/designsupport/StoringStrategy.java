package com.example.pbt.designpattern.strategy.designsupport;

public interface StoringStrategy {
    void cache(String value);

    String retreive();
}
