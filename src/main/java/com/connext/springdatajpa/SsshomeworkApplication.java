package com.connext.springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SsshomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsshomeworkApplication.class, args);
    }

}

