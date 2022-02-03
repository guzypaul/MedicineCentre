package by.guzypaul.medicinecentre.entity;

import java.util.Arrays;

/**
 * The enum Appointment status.
 * @author Guziy Paul
 */
public enum AppStatus {
    /**
     * Claimed appointment status.
     */
    CLAIMED,
    /**
     * Confirmed appointment status.
     */
    CONFIRMED,
    /**
     * Canceled appointment status.
     */
    CANCELED;

    public static boolean isValidAppointmentStatus(String status) {
        return Arrays.stream(AppStatus.values())
                .anyMatch(currentStatus -> currentStatus.toString().equals(status.toUpperCase()));
    }
}
