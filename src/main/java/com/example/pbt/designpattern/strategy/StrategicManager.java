package com.example.pbt.designpattern.strategy;

import com.example.pbt.designpattern.strategy.designsupport.StoringStrategy;
import lombok.Setter;

@Setter
public class StrategicManager {
    private StoringStrategy storingStrategy;

    public void store(String value) {
        storingStrategy.cache(value);
    }

    public String getValue() {
        return storingStrategy.retreive();
    }
}
