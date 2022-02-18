package com.example.pbt.ereditance;

import com.example.pbt.ereditance.support.Color;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
public abstract class Shape {

    @Autowired
    protected Color color;
}
