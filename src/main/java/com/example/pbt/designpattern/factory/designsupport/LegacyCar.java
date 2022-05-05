package com.example.pbt.designpattern.factory.designsupport;

public class LegacyCar implements Car{

    @Override
    public String getFuel() {
        return "Gasoline";
    }
}
