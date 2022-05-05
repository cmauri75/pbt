package com.example.pbt.visitor;

import com.example.pbt.visitor.designSupport.ValutateVisitor;
import com.example.pbt.visitor.support.Person;

public class GoodManager {

    public int valutate(Person person, ValutateVisitor policy) {
        return person.valutate(policy);
    }

}
