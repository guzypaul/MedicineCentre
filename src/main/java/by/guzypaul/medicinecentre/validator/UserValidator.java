package by.guzypaul.medicinecentre.validator;

import by.guzypaul.medicinecentre.entity.User;

import java.util.Arrays;

public class UserValidator {
    private enum Role {
        ADMIN, USER, MODERATOR
    }

    private static final String EMAIL_REGEX = "\\w+@\\p{Alpha}+\\.\\p{Alpha}{2,}";

    public boolean validateUser(User user) {
        return user != null && isValidName(user.getName())
                && isValidSurname(user.getSurname())
                && isValidEmail(user.getEmail())
                && isValidPassword(user.getPassword())
                && isValidPhone(user.getPhone())
                && isValidRole(user.getRole());
    }

    public boolean isValidName(String name) {
        return name != null && name.length() >= 2 && name.length() <= 30;
    }

    public boolean isValidSurname(String surname) {
        return surname != null && surname.length() >= 2 && surname.length() <= 30;
    }

    public boolean isValidEmail(String email) {
        return email != null && !email.isEmpty() && email.length() <= 45 && email.matches(EMAIL_REGEX);
    }

    public boolean isValidPassword(String password) {
        return password != null && !password.isEmpty() && password.length() >= 4 && password.length() <= 60;
    }

    public boolean isValidPhone(String phone) {
        return phone != null && !phone.isEmpty() && phone.length() <= 15;
    }

    public boolean isValidRole(String role) {
        return role != null && Arrays.stream(UserValidator.Role.values())   //todo check
                .anyMatch(currentRole -> currentRole.toString().toUpperCase().equals(role.toUpperCase()));
    }
}
