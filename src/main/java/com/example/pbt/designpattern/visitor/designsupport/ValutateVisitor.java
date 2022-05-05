package com.example.pbt.designpattern.visitor.designsupport;

import com.example.pbt.designpattern.visitor.support.Professor;
import com.example.pbt.designpattern.visitor.support.Student;

public interface ValutateVisitor {
    int valutate(Professor professor);
    int valutate(Student student);
}
