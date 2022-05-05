package com.example.pbt.visitor.designSupport;

import com.example.pbt.visitor.support.Professor;
import com.example.pbt.visitor.support.Student;

public class AcademicStrategy implements ValutateVisitor{

    @Override
    public int valutate(Professor professor) {
        return 2;
    }

    @Override
    public int valutate(Student student) {
        return 3;
    }
}
