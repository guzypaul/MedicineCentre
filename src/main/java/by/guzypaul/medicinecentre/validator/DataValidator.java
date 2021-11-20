package by.guzypaul.medicinecentre.validator;

public class DataValidator {
    private static final String DATE_REGEX = "\\d\\d\\d\\d-\\d\\d-\\d\\d";
    private final static String TIME_REGEX = "\\d\\d:\\d\\d:\\d\\d";
    private final static String NUMBERS_REGEX = "\\d{1,10}";

    public static boolean isDateFormatValid(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        return text.matches(DATE_REGEX);
    }

    public static boolean isTimeFormatValid(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        return text.matches(TIME_REGEX);
    }

    public static boolean isOnlyNumbers(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        return text.matches(NUMBERS_REGEX);
    }
}
