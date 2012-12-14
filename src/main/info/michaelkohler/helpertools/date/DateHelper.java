package info.michaelkohler.helpertools.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateHelper {
  private static final Locale DEFAULT_LOCALE = Locale.ENGLISH;
  private static final String SIMPLE_DATE_FORMAT = "yyyy/MM/dd";

  /**
   * Convert string to date
   * @param dateStr String to be converted.
   * @return A {@link Date} object representation of the given string.
   */
  public static Date strToDate(String dateStr) {
    if(dateStr.equalsIgnoreCase("today"))
      return new Date();
    else if(dateStr.equalsIgnoreCase("yesterday")) {
      Calendar cal = new GregorianCalendar();
      cal.roll(Calendar.DATE, false);
      return cal.getTime();
    }
    else if(dateStr.equalsIgnoreCase("tomorrow")) {
      Calendar cal = new GregorianCalendar();
      cal.roll(Calendar.DATE, true);
      return cal.getTime();
    }
    
    try {
      return new SimpleDateFormat(SIMPLE_DATE_FORMAT, DEFAULT_LOCALE).parse(dateStr);
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }
}
