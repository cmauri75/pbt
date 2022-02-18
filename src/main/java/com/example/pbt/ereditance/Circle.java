package com.example.pbt.ereditance;

import com.example.pbt.ereditance.support.Radius;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Circle extends Shape{

    private Radius radius;

    public String printMe() {
        return "It's me";
    }

    public String printAll(){
        return "Radius: "+radius.printMe()+" Color: "+color.printMe();
    }
}
