package com.yash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.yash")
@EnableJpaRepositories(basePackages = {"com.yash.repository"})
public class SpringLoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringLoginApplication.class, args);
    }
}
