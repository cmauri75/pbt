package com.example.pbt.visitor.designSupport;

import com.example.pbt.visitor.support.Professor;
import com.example.pbt.visitor.support.Student;

public class ResearchStrategy implements ValutateVisitor{

    @Override
    public int valutate(Professor professor) {
        return 0;
    }

    @Override
    public int valutate(Student student) {
        return 1;
    }
}
