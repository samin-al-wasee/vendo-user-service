package com.vendo.user_service.factory;

import com.vendo.user_service.model.User;

public class UserFactory {
    public static User createValidUser() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("johndoe@example.com");
        return user;
    }

    public static User createUserWithInvalidEmail() {
        User user = createValidUser();
        user.setEmail("invalid-email");
        return user;
    }

    public static User createUserWithInvalidFirstName() {
        User user = createValidUser();
        user.setFirstName("John123");
        return user;
    }

    public static User createUserWithInvalidLastName() {
        User user = createValidUser();
        user.setLastName("Doe123");
        return user;
    }
}
