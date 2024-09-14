package com.CineJaro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = "com.CineJaro")
@EnableCaching
public class CineJaroApplication {
    public static void main(String[] args) {
        SpringApplication.run(CineJaroApplication.class, args);
    }
}