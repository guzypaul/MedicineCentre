package by.guzypaul.medicinecentre.validator;

import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.entity.User;

import java.util.Arrays;

public class DoctorValidator {
    private static final String RANK = "([\\p{Alpha}А-Яа-я]{1,45}[\\s-]?){0,9}"; //todo check varchar(45)

    private enum Qualification {
        OPHTHALMOLOGIST, DENTIST, SURGEON;
    }

    public boolean validateDoctor(Doctor doctor) {
        return doctor != null && isValidQualification(doctor.getQualification())
                && isValidRank(doctor.getRank())
                && isValidDoctorInfo(doctor.getDoctorInfo());
    }

    private boolean isValidQualification(String qualification) {
        return qualification != null && Arrays.stream(Qualification.values())   //todo check
                .anyMatch(currentQualification -> currentQualification.toString().toUpperCase().equals(qualification.toUpperCase()));
    }

    private boolean isValidRank(String text) {
        return text != null && !text.isEmpty() && text.matches(RANK);
    }

    private boolean isValidDoctorInfo(User doctorInfo) {    //todo double check
        return doctorInfo != null;
    } // TODO
}
