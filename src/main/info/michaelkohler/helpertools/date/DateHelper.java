package info.michaelkohler.helpertools.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateHelper {
    private static final Locale DEFAULT_LOCALE = Locale.ENGLISH;
    private static final String SIMPLE_DATE_FORMAT = "yyyy/MM/dd";
    private static final String TOMORROW = "tomorrow";
    private static final String YESTERDAY = "yesterday";
    private static final String TODAY = "today";
    private static DateFormat dateFormatter;
    
    static{
        dateFormatter = new SimpleDateFormat(SIMPLE_DATE_FORMAT, DEFAULT_LOCALE);
        dateFormatter.setLenient(false);
    }

    /**
     * Convert string to date
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

    public static String dateToStr(Date date) {
        return dateFormatter.format(date);
    }
    
    public static Date todayDate() {
        return new Date();
    }
    
    public static Date yesterdayDate() {
        Calendar cal = new GregorianCalendar();
        cal.roll(Calendar.DATE, false);
        return cal.getTime();
    }
    
    public static Date tomorrowDate() {
        Calendar cal = new GregorianCalendar();
        cal.roll(Calendar.DATE, true);
        return cal.getTime();
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
