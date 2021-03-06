package by.guzypaul.medicinecentre.service.validator;

import by.guzypaul.medicinecentre.entity.Procedure;
import by.guzypaul.medicinecentre.entity.Qualification;
import by.guzypaul.medicinecentre.service.checker.FileFormatChecker;

import java.math.BigDecimal;

/**
 * The type Procedure validator.
 *
 * @author Guziy Paul
 */
public class ProcedureValidator {
    private FileFormatChecker formatChecker;
    private static final String NAME_REGEX = "([\\p{Alpha}А-Яа-я]{3,15}[\\s-]?){0,9}";
    private static final String DESCRIPTION_REGEX = "[.[^<>]]{5,1000}";
    private static final BigDecimal MAX_PRICE_VALUE = new BigDecimal("100000");
    private static final BigDecimal MIN_PRICE_VALUE = new BigDecimal("1");
    private static final int MAX_DURATION = 480;
    private static final int MIN_DURATION = 5;

    /**
     * Instantiates a new Procedure validator.
     */
    public ProcedureValidator() {
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
     * Validate procedure boolean.
     *
     * @param procedure the procedure
     * @return the boolean
     */
    public boolean validateProcedure(Procedure procedure) {
        return procedure != null && isValidName(procedure.getName())
                && isValidDuration(procedure.getDuration())
                && isValidPrice(procedure.getPrice())
                && isValidDescription(procedure.getDescription())
                && isValidateDoctorPicture(procedure.getImageName())
                && isValidateDoctorQualification(procedure.getDoctorQualification().getName());
    }

    private boolean isValidDuration(int duration) {
        return duration < MAX_DURATION && duration > MIN_DURATION;
    }

    private boolean isValidPrice(BigDecimal price) {
        return price != null && price.compareTo(MAX_PRICE_VALUE) < 1 && price.compareTo(MIN_PRICE_VALUE) > -1;
    }

    private boolean isValidName(String text) {
        return text != null && text.matches(NAME_REGEX);
    }

    private boolean isValidDescription(String text) {
        return text != null && text.matches(DESCRIPTION_REGEX);
    }

    private boolean isValidateDoctorPicture(String profilePictureName) {
        return profilePictureName != null && formatChecker.checkImgFormat(profilePictureName);
    }

    private boolean isValidateDoctorQualification(String qualification) {
        return qualification != null && Qualification.isValidQualification(qualification);
    }
}
