package by.guzypaul.medicinecentre.entity;

import java.util.Arrays;

public enum Qualification {
    DENTIST("Dentist"),
    OPHTHALMOLOGIST("Ophthalmologist"),
    SURGEON("Surgeon"),
    PSYCHOLOGIST("Psychologist"),
    NARCOLOGIST("Narcologist"),
    EXORCIST("Exorcist");


    private final String qualificationName;

    Qualification(String qualificationName) {
        this.qualificationName = qualificationName;
    }

    public String getQualificationName() {
        return qualificationName;
    }

    public static boolean isValidQualification(String qualification) {
        return Arrays.stream(Qualification.values())
                .anyMatch(currentQualification -> currentQualification.getQualificationName().toUpperCase().equals(qualification.toUpperCase()));
    }
}
