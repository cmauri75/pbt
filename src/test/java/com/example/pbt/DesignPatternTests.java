package com.example.pbt;

import com.example.pbt.designpattern.strategy.StrategicManager;
import com.example.pbt.designpattern.strategy.designsupport.LazyStoringStrategy;
import com.example.pbt.designpattern.strategy.designsupport.MemoryStoringStrategy;
import com.example.pbt.designpattern.visitor.BadManager;
import com.example.pbt.designpattern.visitor.GoodManager;
import com.example.pbt.designpattern.visitor.designsupport.AcademicStrategy;
import com.example.pbt.designpattern.visitor.support.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DesignPatternTests {
    BadManager badManager = new BadManager();
    GoodManager goodManager = new GoodManager();

    @Test
    void testVisitor() {
        Assertions.assertEquals(3, badManager.valutate(new Student(), BadManager.ValutationPolicy.ACADEMIC));
        Assertions.assertEquals(3, goodManager.valutate(new Student(), new AcademicStrategy()));
    }

    StrategicManager strategicManager = new StrategicManager();

    @Test
    void testStrategy() {
        strategicManager.setStoringStrategy(new MemoryStoringStrategy());
        strategicManager.store("Test");
        Assertions.assertEquals("Test",strategicManager.getValue());

        strategicManager.setStoringStrategy(new LazyStoringStrategy());
        strategicManager.store("Test");
        Assertions.assertNotEquals("Test",strategicManager.getValue());
    }



}
