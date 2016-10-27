package io.door2door.analytics.base;

/**
 * Helper class for formatting of dates.
 */
public class DateFormattingHelper {

    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZZZZZ";

    /**
     * @return the default date format.
     */
    public String getDefaultDateFormat() {
        return DATE_FORMAT_PATTERN;
    }
}
