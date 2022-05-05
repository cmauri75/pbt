package com.example.pbt.designpattern.visitor;

import com.example.pbt.designpattern.visitor.designsupport.ValutateVisitor;
import com.example.pbt.designpattern.visitor.support.Person;

public class GoodManager {

    public int valutate(Person person, ValutateVisitor policy) {
        return person.valutate(policy);
    }

}
