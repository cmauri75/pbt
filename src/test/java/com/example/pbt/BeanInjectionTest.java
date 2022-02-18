package com.example.pbt;

import com.example.pbt.ereditance.Circle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanInjectionTest {

    @Autowired
    Circle circle;

    @Test
    public void tetConstructor() {
        //Circle c = Circle.builder().radius(new Radius()).build();
        Assertions.assertEquals("Radius: SuperRADIUS! Color: Great color*",circle.printAll());
    }


}
