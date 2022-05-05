package com.example.pbt.designpattern.visitor.support;

import com.example.pbt.designpattern.visitor.designsupport.ValutateVisitor;
import lombok.Data;

@Data
public abstract class Person {
    private Integer id;
    private String name;

    public abstract int valutate(ValutateVisitor visitor);
}
