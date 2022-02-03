package by.guzypaul.medicinecentre.service.validator;

import by.guzypaul.medicinecentre.entity.Doctor;
import by.guzypaul.medicinecentre.service.checker.FileFormatChecker;

/**
 * The type Doctor validator.
 *
 * @author Guziy Paul
 */
public class DoctorValidator {
    private FileFormatChecker formatChecker;
    private static final String RANK = "([\\p{Alpha}А-Яа-я]{3,45}[\\s-]?){0,9}";
    private final UserValidator userValidator = new UserValidator();

    /**
     * Instantiates a new Doctor validator.
     */
    public DoctorValidator() {
        formatChecker = new FileFormatChecker();
    }

    /**
     * Sets format checker.
     *
     * @param formatChecker the format checker
     */
    public void setFormatChecker(FileFormatChecker formatChecker) {
        this.formatChecker = formatChecker;
    }

    /**
     * Validate doctor boolean.
     *
     * @param doctor the doctor
     * @return the boolean
     */
    public boolean validateDoctor(Doctor doctor) {
        return doctor != null && isValidQualification(doctor.getQualification().getName())
                && isValidRank(doctor.getRank())
                && userValidator.validateUser(doctor.getDoctorInfo())
                && isValidateDoctorPicture(doctor.getPhotoName());
    }

    /**
     * Validate doctor for updating boolean.
     *
     * @param doctor the doctor
     * @return the boolean
     */
    public boolean validateDoctorForUpdating(Doctor doctor) {
        return doctor != null && isValidQualification(doctor.getQualification().getName())
                && isValidRank(doctor.getRank())
                && isValidateDoctorPicture(doctor.getPhotoName());
    }

    private boolean isValidQualification(String qualification) {
        return qualification != null && qualification.length() >= 3 && qualification.length() <= 30;
    }

    private boolean isValidRank(String text) {
        return text != null && text.matches(RANK);
    }

    private boolean isValidateDoctorPicture(String profilePictureName) {
        return profilePictureName != null && formatChecker.checkImgFormat(profilePictureName);
    }
}
