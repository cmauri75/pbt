package com.example.pbt.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SimpleTimer {
    private Long point;

    public void start() {
        point = System.currentTimeMillis();
    }

    public void end(String text) {
        log.info("{} took: {} seconds",text,(System.currentTimeMillis() - point) / 1000d);
        point = System.currentTimeMillis();
    }
}
