package com.white.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.white.bot.repository")
public class BotApp {
    public static void main(String[] args) {
        SpringApplication.run(BotApp.class, args);
    }
}
