package com.CineJaro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.CineJaro")
public class CineJaroApplication {
    public static void main(String[] args) {
        SpringApplication.run(CineJaroApplication.class, args);
    }
}