package com.example.monolith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
public class DemoMonolithApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMonolithApplication.class, args);
    }

}
