package info.michaelkohler.helpertools;

import info.michaelkohler.helpertools.date.CalendarHelper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalendarHelperTest_IllegalDaysInMonth {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Test
    public void testCalendar_32DaysInJanuary_ExpectException() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 1;
        int day = 32;
        CalendarHelper.date(year, month, day);
    }
    
    @Test
    public void testCalendar_29DaysInFebruaryNonLeapYear_ExpectException() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2011;
        int month = 2;
        int day = 29;
        CalendarHelper.date(year, month, day);
    }
    
    @Test
    public void testCalendar_30DaysInFebruaryLeapYear_ExpectException() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 2;
        int day = 30;
        CalendarHelper.date(year, month, day);
    }
    
    @Test
    public void testCalendar_32DaysInMarch_ExpectException() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 3;
        int day = 32;
        CalendarHelper.date(year, month, day);
    }
    
    @Test
    public void testCalendar_31DaysInApril_ExpectException() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 4;
        int day = 31;
        CalendarHelper.date(year, month, day);
    }
    
    @Test
    public void testCalendar_32DaysInMay_ExpectException() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 5;
        int day = 32;
        CalendarHelper.date(year, month, day);
    }
    
    @Test
    public void testCalendar_31DaysInJune_ExpectException() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 6;
        int day = 31;
        CalendarHelper.date(year, month, day);
    }
    
    @Test
    public void testCalendar_32DaysInJuly_ExpectException() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 7;
        int day = 32;
        CalendarHelper.date(year, month, day);
    }

    @Test
    public void testCalendar_32DaysInAugust_ExpectException() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 8;
        int day = 32;
        CalendarHelper.date(year, month, day);
    }
    
    @Test
    public void testCalendar_31DaysInSeptember_ExpectException() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 9;
        int day = 31;
        CalendarHelper.date(year, month, day);
    }
    
    @Test
    public void testCalendar_32DaysInOctober_ExpectException() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 10;
        int day = 32;
        CalendarHelper.date(year, month, day);
    }
    
    @Test
    public void testCalendar_31DaysInNovember_ExpectException() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 11;
        int day = 31;
        CalendarHelper.date(year, month, day);
    }
    
    @Test
    public void testCalendar_32DaysInDecember_ExpectException() {
        expectedException.expect(IllegalArgumentException.class);
        int year = 2012;
        int month = 12;
        int day = 32;
        CalendarHelper.date(year, month, day);
    }
}
