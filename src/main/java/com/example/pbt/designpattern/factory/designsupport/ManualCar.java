package com.example.pbt.designpattern.factory.designsupport;

public class ManualCar implements Car{
    @Override
    public String getFuel() {
        return "Glycogen";
    }
}
