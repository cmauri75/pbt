package com.example.pbt.designpattern.strategy.designsupport;

public class LazyStoringStrategy implements StoringStrategy{

    @Override
    public void cache(String value) {
        System.out.println(value);
    }

    @Override
    public String retreive() {
        return "Ops, I forgot it!";
    }
}
