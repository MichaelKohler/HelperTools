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

import info.michaelkohler.helpertools.tools.DateTimeValidator;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * A class that provides convenient methods to support dates generated based on
 * the Gregorian calendar. @see {@link GregorianCalendar}.
 *
 * @author isim
 * @version 0.0.1
 */
public final class CalendarHelper {

    /**
     * this class should not be instantiated therefore the constructor is private.
     */
    private CalendarHelper() {
    }

    /**
     * Create a date representation of the specified year, month and day based on
     * the Gregorian calendar. @see {@link GregorianCalendar}.
     *
     * @param year Year to be used.
     * @param month Month to be used.
     * @param day Day to be used.
     * @return A {@link Date} object representing the date of the specified year,
     *         month and day.
     */
    public static Date date(int year, int month, int day) {
        DateTimeValidator.validateDateArguments(year, month, day);
        return new GregorianCalendar(year, month - 1, day).getTime();
    }

    /**
     * Create a date representation of the specified year, month and day with hour,
     * minute and second based on the Gregorian calendar. @see {@link GregorianCalendar}.
     * @param year Year to be used.
     * @param month Month to be used.
     * @param day Day to be used.
     * @param hour Hour to be used.
     * @param minute Minute to be used.
     * @param second Second to be used.
     * @return A {@link Date} object representing the date of the specified year, month
     *         and day with hour, minute and second.
     */
    public static Date datetime(int year, int month, int day,
            int hour, int minute, int second) {
        DateTimeValidator.validateDateTimeArguments(year, month, day, hour, minute,
                                                      second);
        return new GregorianCalendar(year, month - 1, day, hour, minute, second)
                     .getTime();
    }
}
