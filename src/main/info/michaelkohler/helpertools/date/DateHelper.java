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

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * A class of date-related convenient helper methods.
 *
 * @author ivan.sim
 * @version 0.0.1
 */
public final class DateHelper {

    /**
     * this class should not be instantiated therefore the constructor is private.
     */
    private DateHelper() {
    }

    /**
     * Returns today's date.
     *
     * @return A {@link Date} object representation of today's date.
     */
    public static Date todayDate() {
        return new Date();
    }

    /**
     * Returns yesterday's date.
     *
     * @return A {@link Date} object representation of yesterday's date.
     */
    public static Date yesterdayDate() {
        Calendar cal = new GregorianCalendar();
        cal.roll(Calendar.DATE, false);
        return cal.getTime();
    }

    /**
     * Returns tomorrow's date.
     *
     * @return A {@link Date} object representation of tomorrow's date.
     */
    public static Date tomorrowDate() {
        Calendar cal = new GregorianCalendar();
        cal.roll(Calendar.DATE, true);
        return cal.getTime();
    }
}
