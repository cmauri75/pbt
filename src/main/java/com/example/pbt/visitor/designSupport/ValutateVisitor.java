package com.example.pbt.visitor.designSupport;

import com.example.pbt.visitor.support.Professor;
import com.example.pbt.visitor.support.Student;

public interface ValutateVisitor {
    int valutate(Professor professor);
    int valutate(Student student);
}
