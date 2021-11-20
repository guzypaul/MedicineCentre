package by.guzypaul.medicinecentre.validator;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.regex.Pattern;

public class ProcedureValidator {
    private static final Pattern PRICE_REGEX = Pattern.compile("\\d{1,8}(\\.\\d{2,8})",
            Pattern.CASE_INSENSITIVE);
    private static final String NAME_REGEX = "([\\p{Alpha}А-Яа-я]{1,15}[\\s-]?){0,9}";
    private static final String IMAGE_NAME_REGEX = "[\\p{Alpha}А-Яа-я-_]{1,15}\\.jpg";
    private static final String NUMBERS_REGEX = "\\d{1,10}";
    private static final String SPECIAL_CHAR_REGEX = "[.[^<>]]{1,1000}";
    private static final Pattern DURATION_REGEX = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?" +
                    "(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?",
            Pattern.CASE_INSENSITIVE);


    public static boolean isValidDuration(Duration duration) {
        if (duration == null) {
            return false;
        }
        return duration.equals(DURATION_REGEX);
    }

    public static boolean isOnlyNumbers(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        return text.matches(NUMBERS_REGEX);
    }

    public static boolean isValidName(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        return text.matches(NAME_REGEX);
    }

    public static boolean isValidImageName(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        return text.matches(IMAGE_NAME_REGEX);
    }

    public static boolean isValidPrice(BigDecimal price) {
        if (price == null) {
            return false;
        }
        return price.equals(PRICE_REGEX);
    }

    public static boolean isValidDescription(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        return text.matches(SPECIAL_CHAR_REGEX);
    }
}
