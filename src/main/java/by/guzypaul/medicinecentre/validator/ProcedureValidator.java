package by.guzypaul.medicinecentre.validator;

import by.guzypaul.medicinecentre.entity.Procedure;

import java.math.BigDecimal;
//todo fix Validator
public class ProcedureValidator {
    private static final String NAME_REGEX = "([\\p{Alpha}А-Яа-я]{1,15}[\\s-]?){0,9}";
    private static final String IMAGE_NAME_REGEX = "[\\p{Alpha}А-Яа-я-_]{1,15}\\.jpg";
    private static final String SPECIAL_CHAR_REGEX = "[.[^<>]]{1,1000}";
    private static final BigDecimal MAX_PRICE_VALUE = new BigDecimal("100000");
    private static final BigDecimal MIN_PRICE_VALUE = new BigDecimal("1");
    /*private static final Pattern DURATION_REGEX = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?" +
                    "(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?",
            Pattern.CASE_INSENSITIVE);*/

    public boolean validateProcedure(Procedure procedure) {
        return procedure != null && isValidName(procedure.getName())
                && isValidImageName(procedure.getImageName()) && isValidPrice(procedure.getPrice())
                && isValidDescription(procedure.getDescription());
    }

    /*private boolean isValidDuration(Duration duration) {
        if (duration == null) {
            return false;
        }
        return duration.equals(DURATION_REGEX);
    }*/

    private boolean isValidName(String text) {
        return text != null && !text.isEmpty() && text.matches(NAME_REGEX);
    }

    private boolean isValidImageName(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        return text.matches(IMAGE_NAME_REGEX);
    }

    private boolean isValidPrice(BigDecimal price) {
        return price != null && price.compareTo(MAX_PRICE_VALUE) < 1 && price.compareTo(MIN_PRICE_VALUE) > -1;
    }

    private boolean isValidDescription(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        return text.matches(SPECIAL_CHAR_REGEX);
    }
}
