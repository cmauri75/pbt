package com.example.pbt.pit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MathCalculatorTest {

    @Autowired
    MathCalculator calc;

    @Autowired
    MathCalculator2 calc2;

    @Test
    public void complete() {
        Assertions.assertEquals(0, calc.getAbsDouble(0, 1));
        Assertions.assertEquals(12, calc.getAbsDouble(5, 2));
        Assertions.assertEquals(12, calc.getAbsDouble(-5, 2));
    }

    @Test
    public void onlyPositiveCaseTest() {
        Assertions.assertEquals(12, calc2.getAbsDouble(5, 2));
    }

}
