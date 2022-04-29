package com.example.pbt.strategy;

import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class BusinessLogic {

    private String msg = "Business";

    @Setter
    private ComunicateStrategy comunicate;


    public String run() {
        return comunicate.comunicate(msg);
    }
}
