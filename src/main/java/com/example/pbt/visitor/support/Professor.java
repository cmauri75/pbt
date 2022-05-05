package com.example.pbt.visitor.support;

import com.example.pbt.visitor.designSupport.ValutateVisitor;
import lombok.Data;

@Data
public class Professor extends Person {
    Integer dept;

    int researchScore;
    int academicScore;
    int hybridScore;

    public int valutate(ValutateVisitor visitor) {
        return visitor.valutate(this);
    }
}