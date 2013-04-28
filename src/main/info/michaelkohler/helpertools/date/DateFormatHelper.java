/* ============== HelperTools ==============
 * Initial developer: Ivan Sim <ihcsim@gmail.com>
 *
 * =====
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE - Version 2
 *
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 *
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 * TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 * 0. You just DO WHAT THE FUCK YOU WANT TO.
 *
 * =====
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND.
 *
 */
package info.michaelkohler.helpertools.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A class of date-formatting convenient helper methods.
 *
 * @author ivan.sim
 * @version 0.0.1
 */
public final class DateFormatHelper {
    private static final Locale DEFAULT_LOCALE = Locale.ENGLISH;
    private static final String SIMPLE_DATE_FORMAT = "yyyy/MM/dd";
    private static final String TOMORROW = "tomorrow";
    private static final String YESTERDAY = "yesterday";
    private static final String TODAY = "today";
    private static SimpleDateFormat dateFormatter;

    static {
        dateFormatter = new SimpleDateFormat(SIMPLE_DATE_FORMAT, DEFAULT_LOCALE);
        dateFormatter.setLenient(false);
    }

    /**
     * this class should not be instantiated therefore the constructor is private.
     */
    private DateFormatHelper() {
    }

    /**
     * Convert string to date. The {@value DateHelper#SIMPLE_DATE_FORMAT} pattern
     * is used as the default pattern.
     * To change date pattern, @see {@link DateHelper#applyPattern(String)}.
     *
     * @param dateStr String to be converted. Supported constants: today, yesterday,
     *                tomorrow.
     * @return A {@link Date} object representation of the given string.
     * @throws ParseException - If the specified string cannot be parsed
     */
    public static Date strToDate(String dateStr) throws ParseException {
        if (queryForTodayDate(dateStr))
            return DateHelper.todayDate();
        else if (queryForYesterdayDate(dateStr))
            return DateHelper.yesterdayDate();
        else if (queryForTomorrowDate(dateStr))
            return DateHelper.tomorrowDate();
        return dateFormatter.parse(dateStr);
    }

    /**
     * Convert date to string. The {@value DateHelper#SIMPLE_DATE_FORMAT} pattern is used
     * as the default pattern.
     * To change date pattern, @see {@link DateHelper#applyPattern(String)}.
     *
     * @param date Date to be converted
     * @return A {@link String} representation of the given date.
     */
    public static String dateToStr(Date date) {
        return dateFormatter.format(date);
    }

    /**
     * Changes the date pattern used for conversion.
     *
     * @param pattern A date pattern.
     */
    public static void applyPattern(String pattern) {
        dateFormatter.applyPattern(pattern);
    }

    private static boolean queryForTodayDate(String dateStr) {
        return dateStr.equalsIgnoreCase(TODAY);
    }

    private static boolean queryForYesterdayDate(String dateStr) {
        return dateStr.equalsIgnoreCase(YESTERDAY);
    }

    private static boolean queryForTomorrowDate(String dateStr) {
        return dateStr.equalsIgnoreCase(TOMORROW);
    }

}
