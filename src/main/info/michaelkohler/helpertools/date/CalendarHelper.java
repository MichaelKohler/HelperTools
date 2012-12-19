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

import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarHelper {
    /**
     * Create a date representation of the specified year, month and day based on the Gregorian calendar. @see {@link GregorianCalendar}.
     * @param year Year to be used.
     * @param month Month to be used.
     * @param day Day to be used.
     * @return A {@link Date} object representing the date of the specified year, month and day.
     */
    public static Date date(int year, int month, int day) {
        validateDateArguments(year, month, day);
        return new GregorianCalendar(year, month - 1, day).getTime();
    }

    private static void validateDateArguments(int year, int month, int day) {
        if(year < 0)
            throw new IllegalArgumentException("Negative year value cannot be used to create dates");
        if(month < 0)
            throw new IllegalArgumentException("Negative month value cannot be used to create dates");
        if(day < 0)
            throw new IllegalArgumentException("Negative day value cannot be used to create dates");
    }

    public static Date datetime(int year, int month, int day, 
            int hour, int minute, int second) {
        validateDateTimeArguments(year, month, day, hour, minute, second);
        return new GregorianCalendar(year, month - 1, day, hour, minute, second).getTime();
    }

    private static void validateDateTimeArguments(
            int year, int month, int day,
            int hour, int minute, int second) {
        validateDateArguments(year, month, day);
        validateTimeArguments(hour, minute, second);
    }

    private static void validateTimeArguments(int hour, int minute, int second) {
        if(!hourWithinRange(hour))
            throw new IllegalArgumentException("Hour argument falls outside supported range of 0 - 23");
        if(!minuteWithinRange(minute))
            throw new IllegalArgumentException("Minute argument falls outside supported range of 0 - 59");
        if(!secondWithinRange(second))
            throw new IllegalArgumentException("Second argument falls outside supported range of 0 - 59");
    }

    private static boolean hourWithinRange(int hour) {
        return hour >= 0 && hour <= 24;
    }
    
    private static boolean minuteWithinRange(int minute) {
        return minute >= 0 && minute <= 60;
    }
    
    private static boolean secondWithinRange(int second) {
        return second >= 0 && second <= 60;
    }
}
