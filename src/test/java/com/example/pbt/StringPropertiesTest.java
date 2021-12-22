package com.example.pbt;


import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;

public class StringPropertiesTest {

    @Property
    public void concatenationLength(@ForAll String s1, @ForAll String s2) {
        Assertions.assertEquals(s1.length() + s2.length(), (s1 + s2).length());
    }


    //Not true, in case of 0,N or N,1 it fails
    @Property
    public void failTest(@ForAll int i1, @ForAll int i2) {
        Assertions.assertNotEquals(i1*i2,i1);
    }
}