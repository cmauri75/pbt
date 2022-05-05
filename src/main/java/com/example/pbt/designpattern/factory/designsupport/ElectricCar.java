package com.example.pbt.designpattern.factory.designsupport;

public class ElectricCar implements Car{

    @Override
    public String getFuel() {
        return "Electron";
    }
}
