package com.example.pbt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.pbt")
public class PbtApplication {
    public static void main(String[] args) {
        SpringApplication.run(PbtApplication.class, args);
    }
}
