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
package info.michaelkohler.helpertools;

import info.michaelkohler.helpertools.date.CalendarHelper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalendarHelperTest_CreateIllegalDates {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Test
    public void testCalendar_CreateDate_NegativeYear() {
        expectedException.expect(IllegalArgumentException.class);
        int year = -1;
        int month = 12;
        int day = 15;
        CalendarHelper.date(year, month, day);
    }
    
    @Test
    public void testCalendar_CreateDate_NegativeMonth() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = -5;
        int day = 15;
        CalendarHelper.date(year, month, day);
    }
    
    @Test
    public void testCalendar_CreateDate_0thMonth() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 0;
        int day = 15;
        CalendarHelper.date(year, month, day);
    }
    
    @Test
    public void testCalendar_CreateDate_13thMonth() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 13;
        int day = 15;
        CalendarHelper.date(year, month, day);
    }
    
    @Test
    public void testCalendar_CreateDate_NegativeDay() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 5;
        int day = -15;
        CalendarHelper.date(year, month, day);
    }
    
    @Test
    public void testCalendar_CreateDate_0thDay() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 5;
        int day = 0;
        CalendarHelper.date(year, month, day);
    }
    
    @Test
    public void testCalendar_CreateDate_32ndDay() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 5;
        int day = 32;
        CalendarHelper.date(year, month, day);
    }
}
