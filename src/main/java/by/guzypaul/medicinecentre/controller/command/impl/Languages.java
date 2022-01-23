package by.guzypaul.medicinecentre.controller.command.impl;

import java.util.Arrays;

public enum Languages {
    ENGLISH("en_US"),
    ARABIC("ar_US"),
    CHINA("zh_CN");

    private final String localeName;

    Languages(String localeName) {
        this.localeName = localeName;
    }

    public String getLocaleName() {
        return localeName;
    }

    public static boolean isValidLanguage(String locale) {
        return Arrays.stream(Languages.values())
                .anyMatch(language -> language.getLocaleName().toUpperCase().equals(locale.toUpperCase()));
    }
}
