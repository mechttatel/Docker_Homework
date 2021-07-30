package com.drink.drink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.drink.drink.repository")

public class DrinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrinkApplication.class, args);
    }

}
