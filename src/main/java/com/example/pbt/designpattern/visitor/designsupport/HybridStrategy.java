package com.example.pbt.designpattern.visitor.designsupport;

import com.example.pbt.designpattern.visitor.support.Professor;
import com.example.pbt.designpattern.visitor.support.Student;

public class HybridStrategy implements ValutateVisitor{

    @Override
    public int valutate(Professor professor) {
        return 4;
    }

    @Override
    public int valutate(Student student) {
        return 5;
    }
}
