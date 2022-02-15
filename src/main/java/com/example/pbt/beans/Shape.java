package com.example.pbt.beans;

import com.example.pbt.beans.support.Color;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
public abstract class Shape {

    @Autowired
    protected Color color;
}
