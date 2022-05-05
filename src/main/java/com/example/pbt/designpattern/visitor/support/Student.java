package com.example.pbt.designpattern.visitor.support;

import com.example.pbt.designpattern.visitor.designsupport.ValutateVisitor;
import lombok.Data;

@Data
public class Student extends Person{
    int researchScore;
    int academicScore;
    int hybridScore;

    public int valutate(ValutateVisitor visitor) {
        return visitor.valutate(this);
    }

}
