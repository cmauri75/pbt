package com.example.pbt.visitor.support;

import com.example.pbt.visitor.designSupport.ValutateVisitor;
import lombok.Data;

@Data
public abstract class Person {
    private Integer id;
    private String name;

    public abstract int valutate(ValutateVisitor visitor);
}
