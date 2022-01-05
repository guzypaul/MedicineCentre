package by.guzypaul.medicinecentre.controller.util;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Util class for finding last page
 * @author Guziy Paul
 */
public final class PageFinder {
    private static final Pattern URL_PATTERN = Pattern.compile("/controller+.*");

    private PageFinder() {
    }

    /**
     * Find last page string.
     *
     * @param request the request
     * @return the string
     */
    public static String findLastPage(HttpServletRequest request) {
        Matcher matcher = URL_PATTERN.matcher(request.getHeader("referer"));
        matcher.find();
        return matcher.group();
    }
}
