package com.example.pi2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pi2024Application {
    public static void main(String[] args) { SpringApplication.run(Pi2024Application.class, args);
        System.setProperty("java.library.path", "/usr/lib/");}
}
