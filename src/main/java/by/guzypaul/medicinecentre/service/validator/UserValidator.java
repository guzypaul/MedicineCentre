package by.guzypaul.medicinecentre.service.validator;

import by.guzypaul.medicinecentre.entity.Role;
import by.guzypaul.medicinecentre.entity.User;

/**
 * The type User validator.
 * @author Guziy Paul
 */
public class UserValidator {

    private static final String EMAIL_REGEX = "^([а-яa-z0-9_-]+\\.)*[а-яa-z0-9_-]+@[а-яa-z0-9_-]" +
            "+(\\.[а-яa-z0-9_-]+)*\\.[а-яa-z]{2,6}$";

    /**
     * Validate user boolean.
     *
     * @param user the user
     * @return the boolean
     */
    public boolean validateUser(User user) {
        return user != null && isValidName(user.getName())
                && isValidSurname(user.getSurname())
                && isValidEmail(user.getEmail())
                && isValidPassword(user.getPassword())
                && isValidPhone(user.getPhone())
                && isValidRole(user.getRole().name());
    }

    /**
     * Validate user for updating boolean.
     *
     * @param user the user
     * @return the boolean
     */
    public boolean validateUserForUpdating(User user) {
        return user != null && isValidName(user.getName())
                && isValidSurname(user.getSurname())
                && isValidEmail(user.getEmail())
                && isValidPhone(user.getPhone())
                && isValidRole(String.valueOf(user.getRole()));
    }

    private boolean isValidName(String name) {
        return name != null && name.length() >= 2 && name.length() <= 30;
    }

    private boolean isValidSurname(String surname) {
        return surname != null && surname.length() >= 2 && surname.length() <= 30;
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches(EMAIL_REGEX);
    }

    private boolean isValidPassword(String password) {
        return password != null && password.length() >= 4 && password.length() <= 60;
    }

    private boolean isValidPhone(String phone) {
        return phone != null && !phone.isEmpty() && phone.length() >= 8 && phone.length() <= 15;
    }

    private boolean isValidRole(String role) {
        return role != null && Role.isValidARole(role);
    }
}
