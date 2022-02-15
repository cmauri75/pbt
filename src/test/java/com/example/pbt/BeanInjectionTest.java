package com.example.pbt;

import com.example.pbt.beans.Circle;
import com.example.pbt.beans.support.Color;
import com.example.pbt.beans.support.Radius;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
public class BeanInjectionTest {

    @Autowired
    Circle circle;

    @Test
    public void tetConstructor() {
        //Circle c = Circle.builder().radius(new Radius()).build();
        System.err.println(circle.printAll());
        Assertions.assertEquals(circle.printMe(),"It's me");
    }


}
