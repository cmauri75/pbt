package com.example.pbt;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;

public class AdditionPropertiesTest {

    @Property
    public void commutative(@ForAll int randomX, @ForAll int randomY) {
        int result1 = Calculator.add(randomX, randomY);
        int result2 = Calculator.add(randomY, randomX);

        Assertions.assertEquals(result1, result2);
    }

    @Property
    public void associative(@ForAll int randomX) {
        int result1 = Calculator.add(randomX, 1);
        result1 = Calculator.add(result1, 1);
        int result2 = Calculator.add(randomX, 2);

        Assertions.assertEquals(result1, result2);
    }

    @Property
    public void identity(@ForAll int randomX) {
        int result1 = Calculator.add(randomX, 0);

        Assertions.assertEquals(result1, randomX);
    }

}
