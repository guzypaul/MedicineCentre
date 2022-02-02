package by.guzypaul.medicinesentre.service.validator;

import by.guzypaul.medicinecentre.entity.Role;
import by.guzypaul.medicinecentre.entity.User;
import by.guzypaul.medicinecentre.service.validator.UserValidator;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserValidatorTest {
    private UserValidator userValidator;
    private User testUser;

    @BeforeEach
    void setUp() {
        userValidator = new UserValidator();
        testUser = new User(1, "Ivan", "Petrov", "ivan_petrov@gmail.com",
                "12345678", "375257897878", Role.USER);
    }

    @Test
    void validateNullUserTest() {
        Assert.assertFalse(userValidator.validateUser(null));
    }

    @Test
    void validateUserWithInvalidNameTest() {
        testUser.setName("F");
        Assert.assertFalse(userValidator.validateUser(testUser));
    }

    @Test
    void validateUserWithNullNameTest() {
        testUser.setName(null);
        Assert.assertFalse(userValidator.validateUser(testUser));
    }

    @Test
    void validateUserWithInvalidSurnameTest() {
        testUser.setSurname("d");
        Assert.assertFalse(userValidator.validateUser(testUser));
    }

    @Test
    void validateUserWithNullSurnameTest() {
        testUser.setSurname(null);
        Assert.assertFalse(userValidator.validateUser(testUser));
    }

    @Test
    void validateUserWithInvalidPasswordTest() {
        testUser.setPassword("123");
        Assert.assertFalse(userValidator.validateUser(testUser));
    }

    @Test
    void validateUserWithNullPasswordTest() {
        testUser.setPassword(null);
        Assert.assertFalse(userValidator.validateUser(testUser));
    }

    @Test
    void validateUserWithInvalidEmailTest() {
        testUser.setEmail("vas.gmaail@com");
        Assert.assertFalse(userValidator.validateUser(testUser));
    }

    @Test
    void validateUserWithNullEmailTest() {
        testUser.setEmail(null);
        Assert.assertFalse(userValidator.validateUser(testUser));
    }

    @Test
    void validateUserWithInvalidPhoneNumberTest() {
        testUser.setPhone("3752500");
        Assert.assertFalse(userValidator.validateUser(testUser));
    }

    @Test
    void validateUserWithNullPhoneNumberTest() {
        testUser.setPhone(null);
        Assert.assertFalse(userValidator.validateUser(testUser));
    }
}
