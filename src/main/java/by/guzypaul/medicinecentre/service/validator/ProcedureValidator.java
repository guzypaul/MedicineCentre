package by.guzypaul.medicinecentre.service.validator;

import by.guzypaul.medicinecentre.entity.Procedure;

import java.math.BigDecimal;

/**
 * The type Procedure validator.
 * @author Guziy Paul
 */
public class ProcedureValidator {
    private static final String NAME_REGEX = "([\\p{Alpha}А-Яа-я]{1,15}[\\s-]?){0,9}";
    private static final String DESCRIPTION_REGEX = "[.[^<>]]{1,1000}";
    private static final BigDecimal MAX_PRICE_VALUE = new BigDecimal("100000");
    private static final BigDecimal MIN_PRICE_VALUE = new BigDecimal("1");
    private static final int MAX_DURATION = 480;
    private static final int MIN_DURATION = 5;

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
                && isValidDescription(procedure.getDescription());
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
}
