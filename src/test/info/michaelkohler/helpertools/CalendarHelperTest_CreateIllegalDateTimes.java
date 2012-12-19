package info.michaelkohler.helpertools;

import info.michaelkohler.helpertools.date.CalendarHelper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalendarHelperTest_CreateIllegalTimes {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Test
    public void testCalendar_CreateDateTime_NegativeHour() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 12;
        int day = 15;
        int hour = -1;
        int minute = 0;
        int second = 0;
        CalendarHelper.datetime(year, month, day, hour, minute, second);
    }
    
    @Test
    public void testCalendar_CreateDateTime_NegativeMinute() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 12;
        int day = 15;
        int hour = 0;
        int minute = -1;
        int second = 0;
        CalendarHelper.datetime(year, month, day, hour, minute, second);
    }
    
    @Test
    public void testCalendar_CreateDateTime_NegativeSecond() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 12;
        int day = 15;
        int hour = 0;
        int minute = 0;
        int second = -1;
        CalendarHelper.datetime(year, month, day, hour, minute, second);
    }
}
