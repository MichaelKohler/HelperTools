/* ============== HelperTools ==============
 * Initial developer: Lukas Diener <lukas.diener@hotmail.com>
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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * A class of date-related convenient helper methods. 
 * @author ivan.sim
 */
public class DateHelper {
    private static final Locale DEFAULT_LOCALE = Locale.ENGLISH;
    private static final String SIMPLE_DATE_FORMAT = "yyyy/MM/dd";
    private static final String TOMORROW = "tomorrow";
    private static final String YESTERDAY = "yesterday";
    private static final String TODAY = "today";
    private static SimpleDateFormat dateFormatter;
    
    static{
        dateFormatter = new SimpleDateFormat(SIMPLE_DATE_FORMAT, DEFAULT_LOCALE);
        dateFormatter.setLenient(false);
    }

    /**
     * Convert string to date. The {@value DateHelper#SIMPLE_DATE_FORMAT} pattern is used as the default pattern. To change date pattern, @see {@link DateHelper#applyPattern(String)}.
     * @param dateStr String to be converted. Supported constants: today, yesterday, tomorrow.
     * @return A {@link Date} object representation of the given string.
     */
    public static Date strToDate(String dateStr) {
        if(queryForTodayDate(dateStr))
            return todayDate();
        else if(queryForYesterdayDate(dateStr))
            return yesterdayDate();
        else if(queryForTomorrowDate(dateStr))
            return tomorrowDate();
        
        try {
            return dateFormatter.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convert date to string. The {@value DateHelper#SIMPLE_DATE_FORMAT} pattern is used as the default pattern. To change date pattern, @see {@link DateHelper#applyPattern(String)}.
     * @param date Date to be converted
     * @return A {@link String} representation of the given date.
     */
    public static String dateToStr(Date date) {
        return dateFormatter.format(date);
    }
    
    /**
     * Returns today's date.
     * @return A {@link Date} object representation of today's date.
     */
    public static Date todayDate() {
        return new Date();
    }
    
    /**
     * Returns yesterday's date.
     * @return A {@link Date} object representation of yesterday's date.
     */
    public static Date yesterdayDate() {
        Calendar cal = new GregorianCalendar();
        cal.roll(Calendar.DATE, false);
        return cal.getTime();
    }
    
    /**
     * Returns tomorrow's date.
     * @return A {@link Date} object representation of tomorrow's date.
     */
    public static Date tomorrowDate() {
        Calendar cal = new GregorianCalendar();
        cal.roll(Calendar.DATE, true);
        return cal.getTime();
    }
    
    /**
     * Changes the date pattern used for conversion.
     * @param pattern A date pattern.
     */
    public static void applyPattern(String pattern){
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
