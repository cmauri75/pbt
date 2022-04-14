package com.example.pbt.pit;

import org.springframework.stereotype.Service;

@Service
public class MathCalculator {

    /**
     * Utility
     *
     * @param i the input
     * @param j param to be added
     * @return double of absolute input and add second parameterm
     */
    public Integer getAbsDouble(Integer i, Integer j) {
        if (i == 0) return 0;

        int ret = 0;

        if (i < 0) i = i * -1;
        i = i * 2;
        i = i + j;
        return i;

    }
}
