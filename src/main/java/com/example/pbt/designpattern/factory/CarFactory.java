package com.example.pbt.designpattern.factory;

import com.example.pbt.designpattern.factory.designsupport.Car;
import com.example.pbt.designpattern.factory.designsupport.ElectricCar;
import com.example.pbt.designpattern.factory.designsupport.LegacyCar;
import com.example.pbt.designpattern.factory.designsupport.ManualCar;

public class CarFactory {
    private CarFactory(){};

    public enum CarType {Electric, Legacy, Manual}
    public static Car createCar(CarType type) {
        switch (type) {
            case Legacy: return new LegacyCar();
            case Manual: return new ManualCar();
            case Electric: return new ElectricCar();
        }
        return null;
    }
}
