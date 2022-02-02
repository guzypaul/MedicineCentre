package by.guzypaul.medicinecentre.service.validator;

import by.guzypaul.medicinecentre.entity.Doctor;

/**
 * The type Doctor validator.
 * @author Guziy Paul
 */
public class DoctorValidator {
    private static final String RANK = "([\\p{Alpha}А-Яа-я]{1,45}[\\s-]?){0,9}";
    private final UserValidator userValidator = new UserValidator();

    /**
     * Validate doctor boolean.
     *
     * @param doctor the doctor
     * @return the boolean
     */
    public boolean validateDoctor(Doctor doctor) {
        return doctor != null && isValidQualification(doctor.getQualification())
                && isValidRank(doctor.getRank())
                && userValidator.validateUser(doctor.getDoctorInfo());
    }

    /**
     * Validate doctor for updating boolean.
     *
     * @param doctor the doctor
     * @return the boolean
     */
    public boolean validateDoctorForUpdating(Doctor doctor) {
        return doctor != null && isValidQualification(doctor.getQualification())
                && isValidRank(doctor.getRank());
    }

    private boolean isValidQualification(String qualification) {
        return qualification != null && qualification.length() <= 30;
    }

    private boolean isValidRank(String text) {
        return text != null && text.matches(RANK);
    }
}
