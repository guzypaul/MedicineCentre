package by.guzypaul.medicinecentre.validator;

public class ProcedureValidator {
    private static final String PRICE_REGEX = "\\d{1,8}(\\.\\d{2,8})";
    private static final String NAME_REGEX = "([\\p{Alpha}А-Яа-я]{1,15}[\\s-]?){0,9}";
    private static final String IMAGE_NAME_REGEX = "[\\p{Alpha}А-Яа-я-_]{1,15}\\.jpg";
    private static final String NUMBERS_REGEX = "\\d{1,10}";
    private static final String SPECIAL_CHAR_REGEX = "[.[^<>]]{1,1000}";

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

    public static boolean isValidPrice(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        return text.matches(PRICE_REGEX);
    }

    public static boolean isValidDescription(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        return text.matches(SPECIAL_CHAR_REGEX);
    }
}
