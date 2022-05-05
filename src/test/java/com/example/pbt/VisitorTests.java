package com.example.pbt;

import com.example.pbt.visitor.BadManager;
import com.example.pbt.visitor.GoodManager;
import com.example.pbt.visitor.designSupport.AcademicStrategy;
import com.example.pbt.visitor.designSupport.ValutateVisitor;
import com.example.pbt.visitor.support.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VisitorTests {
    BadManager badManager = new BadManager();
    GoodManager goodManager = new GoodManager();

    @Test
    void test() {
        Assertions.assertEquals(3, badManager.valutate(new Student(), BadManager.ValutationPolicy.ACADEMIC));
        Assertions.assertEquals(3, goodManager.valutate(new Student(), new AcademicStrategy()));
    }

}
