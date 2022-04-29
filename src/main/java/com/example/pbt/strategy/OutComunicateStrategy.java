package com.example.pbt.strategy;

import org.springframework.stereotype.Component;

@Component
public class OutComunicateStrategy implements  ComunicateStrategy{
    @Override
    public String comunicate(String message) {
        System.out.println("Out: "+message);
        return "Out";
    }
}
