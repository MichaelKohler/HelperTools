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
package info.michaelkohler.helpertools.tools;

import java.util.GregorianCalendar;

/**
 * A class that provides convenient methods to validate dates and times values based on the Gregorian calendar. @see {@link GregorianCalendar}.
 * @author isim
 *
 */
public class DateTimeValidator {

    public static void validateDateArguments(int year, int month, int day) {
        if(!yearWithinRange(year))
            throw new IllegalArgumentException("Year argument must be positive");
        if(!monthWithinRange(month))
            throw new IllegalArgumentException("Month argument falls outside of the supported range of 1 - 12");
        if(!dayWithinRange(day))
            throw new IllegalArgumentException("Day argument falls outside of the supported range of 1 - 31");

        if(isFebruary(month)) {
            if(!isLeapYear(year) && day >= 29)
                throw new IllegalArgumentException();
            if(isLeapYear(year) && day >= 30)
                throw new IllegalArgumentException();
        }
        else if(isApril(month) || isJune(month) || isSeptember(month) || isNovember(month))
            if(day >= 31)
                throw new IllegalArgumentException();
    }
    
    private static boolean yearWithinRange(int year) {
        return year > 0;
    }
    
    private static boolean monthWithinRange(int month) {
        return month > 0 && month <= 12;
    }

    private static boolean dayWithinRange(int day) {
        return day > 0 && day <= 31;
    }
    
    private static boolean isFebruary(int month) {
        return month == 2;
    }
    
    private static boolean isApril(int month) {
        return month == 4;
    }
    
    private static boolean isJune(int month) {
        return month == 6;
    }
    
    private static boolean isSeptember(int month) {
        return month == 9;
    }
    
    private static boolean isNovember(int month) {
        return month == 11;
    }

    private static boolean isLeapYear(int year){
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.isLeapYear(year);
    }
}
