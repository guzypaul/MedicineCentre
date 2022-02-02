package by.guzypaul.medicinecentre.entity;

import java.util.Arrays;

/**
 * The enum Role.
 * @author Guziy Paul
 */
public enum Role {
    /**
     * Admin role.
     */
    ADMIN,
    /**
     * Moderator role.
     */
    MODERATOR,
    /**
     * User role.
     */
    USER,
    /**
     * Doctor role.
     */
    DOCTOR;

    public static boolean isValidARole(String role) {
        return Arrays.stream(Role.values())
                .anyMatch(currentRole -> currentRole.toString().equalsIgnoreCase(role));
    }
}
