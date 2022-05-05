package com.example.pbt.designpattern.strategy.designsupport;

public class MemoryStoringStrategy implements StoringStrategy{

    private String myTreasure;
    
    @Override
    public void cache(String value) {
        myTreasure = value;
    }

    @Override
    public String retreive() {
        return myTreasure;
    }
}
