package com.vendo.user_service.repository;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.vendo.user_service.constant.ValidationConstants;
import com.vendo.user_service.factory.UserFactory;
import com.vendo.user_service.model.User;

@DataJpaTest
@SpringJUnitConfig
@ActiveProfiles("test")
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    private static final Pattern NAME_PATTERN = Pattern.compile(ValidationConstants.NAME_PATTERN);
    private static final Pattern EMAIL_PATTERN = Pattern.compile(ValidationConstants.EMAIL_PATTERN);

    @Test
    public void testInvalidFirstName() {
        User user = UserFactory.createUserWithInvalidFirstName();

        boolean isValid = NAME_PATTERN.matcher(user.getFirstName()).matches();
        assertFalse(isValid, "First name can only contain alphabets, hyphens, and a single dot");
    }

    @Test
    public void testInvalidLastName() {
        User user = UserFactory.createUserWithInvalidLastName();

        boolean isValid = NAME_PATTERN.matcher(user.getLastName()).matches();
        assertFalse(isValid, "Last name can only contain alphabets, hyphens, and a single dot");
    }

    @Test
    public void testInvalidEmail() {
        User user = UserFactory.createUserWithInvalidEmail();

        boolean isValid = EMAIL_PATTERN.matcher(user.getEmail()).matches();
        assertFalse(isValid, "Email should be valid");
    }

    @Test
    public void testValidUser() {
        User user = UserFactory.createValidUser();

        boolean isFirstNameValid = NAME_PATTERN.matcher(user.getFirstName()).matches();
        boolean isLastNameValid = NAME_PATTERN.matcher(user.getLastName()).matches();
        boolean isEmailValid = EMAIL_PATTERN.matcher(user.getEmail()).matches();

        assertTrue(isFirstNameValid, "First name should be valid");
        assertTrue(isLastNameValid, "Last name should be valid");
        assertTrue(isEmailValid, "Email should be valid");

        User savedUser = userRepository.save(user);
        assertNotNull(savedUser);
        assertNotNull(savedUser.getId());
        assertEquals("John", savedUser.getFirstName());
    }
}