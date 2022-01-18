package by.guzypaul.medicinecentre.validator;

import by.guzypaul.medicinecentre.entity.Doctor;

public class DoctorValidator {
    private static final String RANK = "([\\p{Alpha}А-Яа-я]{1,45}[\\s-]?){0,9}";
    private final UserValidator userValidator = new UserValidator();

    public boolean validateDoctor(Doctor doctor) {
        return doctor != null && isValidQualification(doctor.getQualification())
                && isValidRank(doctor.getRank())
                && userValidator.validateUser(doctor.getDoctorInfo());
    }

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
