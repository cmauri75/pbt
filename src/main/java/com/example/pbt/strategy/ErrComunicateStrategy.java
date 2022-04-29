package com.example.pbt.strategy;

import org.springframework.stereotype.Component;

@Component
public class ErrComunicateStrategy implements  ComunicateStrategy{
    @Override
    public String comunicate(String message) {
        System.err.println("Err: "+message);
        return "Err";
    }
}
