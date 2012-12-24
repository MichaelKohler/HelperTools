package info.michaelkohler.helpertools;

import info.michaelkohler.helpertools.date.CalendarHelper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalendarHelperTest_CreateIllegalDateTimes {
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
    public void testCalendar_CreateDateTime_25thHour() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 12;
        int day = 15;
        int hour = 25;
        int minute = 0;
        int second = 0;
        CalendarHelper.datetime(year, month, day, hour, minute, second);
    }
    
    @Test
    public void testCalendar_CreateDateTime_30thHour() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 12;
        int day = 15;
        int hour = 30;
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
    public void testCalendar_CreateDateTime_61stMinute() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 12;
        int day = 15;
        int hour = 0;
        int minute = 61;
        int second = 0;
        CalendarHelper.datetime(year, month, day, hour, minute, second);
    }
    
    @Test
    public void testCalendar_CreateDateTime_80thMinute() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 12;
        int day = 15;
        int hour = 0;
        int minute = 80;
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
    
    @Test
    public void testCalendar_CreateDateTime_61stSecond() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 12;
        int day = 15;
        int hour = 0;
        int minute = 0;
        int second = 61;
        CalendarHelper.datetime(year, month, day, hour, minute, second);
    }
    
    @Test
    public void testCalendar_CreateDateTime_90thSecond() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 12;
        int day = 15;
        int hour = 0;
        int minute = 0;
        int second = 90;
        CalendarHelper.datetime(year, month, day, hour, minute, second);
    }
    
    @Test
    public void testCalendar_CreateDate_NegativeYear() {
        expectedException.expect(IllegalArgumentException.class);
        int year = -1;
        int month = 12;
        int day = 15;
        int hour = 0;
        int minute = 0;
        int second = 0;
        CalendarHelper.datetime(year, month, day, hour, minute, second);
    }
    
    @Test
    public void testCalendar_CreateDate_NegativeMonth() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = -5;
        int day = 15;
        int hour = 0;
        int minute = 0;
        int second = 0;
        CalendarHelper.datetime(year, month, day, hour, minute, second);
    }
    
    @Test
    public void testCalendar_CreateDate_NegativeDay() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 5;
        int day = -15;
        int hour = 0;
        int minute = 0;
        int second = 0;
        CalendarHelper.datetime(year, month, day, hour, minute, second);
    }
}
