package by.guzypaul.medicinecentre.validator;

import by.guzypaul.medicinecentre.entity.Procedure;

import java.math.BigDecimal;
import java.time.Duration;

public class ProcedureValidator {
    private static final String NAME_REGEX = "([\\p{Alpha}А-Яа-я]{1,15}[\\s-]?){0,9}";
    private static final String IMAGE_NAME_REGEX = ".+([.](jpg|gif|png|bmp))";
    private static final String DESCRIPTION_REGEX = "[.[^<>]]{1,1000}";
    private static final BigDecimal MAX_PRICE_VALUE = new BigDecimal("100000");
    private static final BigDecimal MIN_PRICE_VALUE = new BigDecimal("1");
    private static final Duration MAX_DURATION = Duration.ofHours(10);
    private static final Duration MIN_DURATION = Duration.ofMinutes(5);

    public boolean validateProcedure(Procedure procedure) {
        return procedure != null && isValidName(procedure.getName())
                && isValidDuration(procedure.getDuration())
                && isValidImageName(procedure.getImageName()) && isValidPrice(procedure.getPrice())
                && isValidDescription(procedure.getDescription());
    }

    private boolean isValidDuration(Duration duration) {
        return duration != null && duration.compareTo(MAX_DURATION) < 1 && duration.compareTo(MIN_DURATION) > -1;
    }

    private boolean isValidPrice(BigDecimal price) {
        return price != null && price.compareTo(MAX_PRICE_VALUE) < 1 && price.compareTo(MIN_PRICE_VALUE) > -1;
    }

    private boolean isValidName(String text) {
        return text != null && text.matches(NAME_REGEX);
    }

    private boolean isValidImageName(String text) {
        return text != null &&  text.matches(IMAGE_NAME_REGEX);
    }

    private boolean isValidDescription(String text) {
        return text != null && text.matches(DESCRIPTION_REGEX);
    }
}
