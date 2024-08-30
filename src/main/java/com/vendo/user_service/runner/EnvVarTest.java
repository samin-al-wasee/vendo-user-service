package com.vendo.user_service.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EnvVarTest implements CommandLineRunner {

    @Value("${POSTGRES_URL}")
    private String postgresUrl;

    @Value("${POSTGRES_USERNAME}")
    private String postgresUsername;

    @Value("${POSTGRES_PASSWORD}")
    private String postgresPassword;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("POSTGRES_URL: " + postgresUrl);
        System.out.println("POSTGRES_USERNAME: " + postgresUsername);
        System.out.println("POSTGRES_PASSWORD: " + postgresPassword);
    }
}
