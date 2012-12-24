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

public class CalendarHelperTest_CreateDateTime {
    @Test
    public void testCalendar_CreateDateTime_NotNull() {
        int year = 2012;
        int month = 12;
        int day = 15;
        int hour = 0;
        int minute = 0;
        int second = 0;
        Date actual = CalendarHelper.datetime(year, month, day, hour, minute, second);
        Assert.assertNotNull(actual);
    }
    
    @Test
    public void testCalendar_CreateMidnight_MatchesExpected() {
        int year = 2012;
        int month = 12;
        int day = 15;
        int hour = 0;
        int minute = 0;
        int second = 0;
        Date actual = CalendarHelper.datetime(year, month, day, hour, minute, second);
        Date expected = new GregorianCalendar(2012, 11, 15, 0, 0, 0).getTime();
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCalendar_CreateTime012415_MatchesExpected() {
        int year = 2012;
        int month = 12;
        int day = 15;
        int hour = 1;
        int minute = 24;
        int second = 15;
        Date actual = CalendarHelper.datetime(year, month, day, hour, minute, second);
        Date expected = new GregorianCalendar(2012, 11, 15, 1, 24, 15).getTime();
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCalendar_CreateTime081500_MatchesExpected() {
        int year = 2012;
        int month = 12;
        int day = 15;
        int hour = 8;
        int minute = 15;
        int second = 0;
        Date actual = CalendarHelper.datetime(year, month, day, hour, minute, second);
        Date expected = new GregorianCalendar(2012, 11, 15, 8, 15, 0).getTime();
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCalendar_CreateNoon_MatchesExpected() {
        int year = 2012;
        int month = 12;
        int day = 15;
        int hour = 12;
        int minute = 30;
        int second = 0;
        Date actual = CalendarHelper.datetime(year, month, day, hour, minute, second);
        Date expected = new GregorianCalendar(2012, 11, 15, 12, 30, 0).getTime();
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCalendar_CreateTime175530_MatchesExpected() {
        int year = 2012;
        int month = 12;
        int day = 15;
        int hour = 17;
        int minute = 55;
        int second = 30;
        Date actual = CalendarHelper.datetime(year, month, day, hour, minute, second);
        Date expected = new GregorianCalendar(2012, 11, 15, 17, 55, 30).getTime();
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCalendar_CreateTime225959_MatchesExpected() {
        int year = 2012;
        int month = 12;
        int day = 15;
        int hour = 22;
        int minute = 59;
        int second = 59;
        Date actual = CalendarHelper.datetime(year, month, day, hour, minute, second);
        Date expected = new GregorianCalendar(2012, 11, 15, 22, 59, 59).getTime();
        Assert.assertEquals(expected, actual);
    }
}
