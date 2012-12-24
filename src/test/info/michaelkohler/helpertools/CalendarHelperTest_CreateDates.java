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

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class CalendarHelperTest_CreateDates {
    @Test
    public void testCalendar_CreateDate20121215_NotNull() {
        int year = 2012;
        int month = 12;
        int day = 15;
        Date actual = CalendarHelper.date(year, month, day);
        Assert.assertNotNull(actual);
    }
    
    @Test
    public void testCalendar_CreateDate20121215_MatchesExpected() {
        int year = 2012;
        int month = 12;
        int day = 15;
        Date actual = CalendarHelper.date(year, month, day);
        Date expected = new GregorianCalendar(2012, 11, 15).getTime();
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCalendar_CreateDate20000131_MatchesExpected() {
        int year = 2000;
        int month = 1;
        int day = 31;
        Date actual = CalendarHelper.date(year, month, day);
        Date expected = new GregorianCalendar(2000, 0, 31).getTime();
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCalendar_CreateDate19701011_MatchesExpected() {
        int year = 1970;
        int month = 10;
        int day = 11;
        Date actual = CalendarHelper.date(year, month, day);
        Date expected = new GregorianCalendar(1970, 9, 11).getTime();
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCalendar_CreateDate20200228_MatchesExpected() {
        int year = 2020;
        int month = 2;
        int day = 28;
        Date actual = CalendarHelper.date(year, month, day);
        Date expected = new GregorianCalendar(2020, 1, 28).getTime();
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCalendar_CreateDate20701011_MatchesExpected() {
        int year = 2070;
        int month = 10;
        int day = 11;
        Date actual = CalendarHelper.date(year, month, day);
        Date expected = new GregorianCalendar(2070, 9, 11).getTime();
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCalendar_CreateDateInYear0_MatchesExpected() {
        int year = 1;
        int month = 1;
        int day = 1;
        Date actual = CalendarHelper.date(year, month, day);
        Date expected = new GregorianCalendar(1, 0, 1).getTime();
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCalendar_CreateDateInYear30000_MatchesExpected() {
        int year = 30000;
        int month = 12;
        int day = 12;
        Date actual = CalendarHelper.date(year, month, day);
        Date expected = new GregorianCalendar(30000, 11, 12).getTime();
        Assert.assertEquals(expected, actual);
    }

}
