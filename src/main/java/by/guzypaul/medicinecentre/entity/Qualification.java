package by.guzypaul.medicinecentre.entity;

import java.util.Arrays;

/**
 * The enum Qualification.
 * @author Guziy Paul
 */
public enum Qualification {
    /**
     * Dentist qualification.
     */
    DENTIST("Dentist"),
    /**
     * Ophthalmologist qualification.
     */
    OPHTHALMOLOGIST("Ophthalmologist"),
    /**
     * Surgeon qualification.
     */
    SURGEON("Surgeon"),
    /**
     * Psychologist qualification.
     */
    PSYCHOLOGIST("Psychologist"),
    /**
     * Narcologist qualification.
     */
    NARCOLOGIST("Narcologist"),
    /**
     * Exorcist qualification.
     */
    EXORCIST("Exorcist");


    private final String qualificationName;

    Qualification(String qualificationName) {
        this.qualificationName = qualificationName;
    }

    /**
     * Gets qualification name.
     *
     * @return the qualification name
     */
    public String getQualificationName() {
        return qualificationName;
    }

    /**
     * Is valid qualification boolean.
     *
     * @param qualification the qualification
     * @return the boolean
     */
    public static boolean isValidQualification(String qualification) {
        return Arrays.stream(Qualification.values())
                .anyMatch(currentQualification -> currentQualification.getQualificationName().equalsIgnoreCase(qualification));
    }
}
