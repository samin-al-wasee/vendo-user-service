package com.vendo.user_service.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EnvVarTest implements CommandLineRunner {

    @Value("${DOTENV_ENABLED:false}")
    private String dotEnvEnabled;

    @Override
    public void run(String... args) throws Exception {
        String messageType = dotEnvEnabled.equals("true") ? "\033[32m.ENV is ENABLED.\033[0m" : "\033[33m.ENV is DISABLED!\033[0m";
        System.out.println(messageType);
    }
}