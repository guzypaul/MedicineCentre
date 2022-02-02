package by.guzypaul.medicinecentre.controller.command.impl;

import java.util.Arrays;

/**
 * The enum Languages.
 * @author Guziy Paul
 */
public enum Languages {
    /**
     * English languages.
     */
    ENGLISH("en_US"),
    /**
     * Arabic languages.
     */
    ARABIC("ar_US"),
    /**
     * China languages.
     */
    CHINA("zh_CN");

    private final String localeName;

    Languages(String localeName) {
        this.localeName = localeName;
    }

    /**
     * Gets locale name.
     *
     * @return the locale name
     */
    public String getLocaleName() {
        return localeName;
    }

    /**
     * Is valid language boolean.
     *
     * @param locale the locale
     * @return the boolean
     */
    public static boolean isValidLanguage(String locale) {
        return Arrays.stream(Languages.values())
                .anyMatch(language -> language.getLocaleName().toUpperCase().equals(locale.toUpperCase()));
    }
}
