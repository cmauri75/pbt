package com.example.pbt.visitor;

import com.example.pbt.visitor.support.Person;
import com.example.pbt.visitor.support.Professor;
import com.example.pbt.visitor.support.Student;

public class BadManager {
    public enum ValutationPolicy {RESEARCH, ACADEMIC, HYBRID}

    public int valutate(Person person, ValutationPolicy policy) {
        switch (policy) {
            case RESEARCH: {
                if (person instanceof Professor) {
                    //.....
                    return 0;
                }
                if (person instanceof Student) {
                    //.....
                    return 1;
                }
                break;
            }
            case ACADEMIC: {
                if (person instanceof Professor) {
                    //.....
                    return 2;
                }
                if (person instanceof Student) {
                    //.....
                    return 3;
                }
                break;
            }
            case HYBRID: {
                if (person instanceof Professor) {
                    //.....
                    return 4;
                }
                if (person instanceof Student) {
                    //.....
                    return 5;
                }
                break;
            }
        }
        return -1;
    }


}
