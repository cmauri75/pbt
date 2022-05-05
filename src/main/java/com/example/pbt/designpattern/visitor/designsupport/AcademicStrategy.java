package com.example.pbt.designpattern.visitor.designsupport;

import com.example.pbt.designpattern.visitor.support.Professor;
import com.example.pbt.designpattern.visitor.support.Student;

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
