package info.michaelkohler.helpertools;

import info.michaelkohler.helpertools.date.DateHelper;

import java.text.ParseException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DateHelperTest_UnsupportedLiterals {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testStrToDate_UnsupportedLiterals_TwoDaysAgo() throws Exception{
        String fixture = "two days ago";
        expectedException.expect(ParseException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_UnsupportedLiterals_OneMonthAgo() throws Exception{
        String fixture = "one month ago";
        expectedException.expect(ParseException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_UnsupportedLiterals_FiveDaysLater() throws Exception{
        String fixture = "five days later";
        expectedException.expect(ParseException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_UnsupportedLiterals_ThreeWeeksAgo() throws Exception{
        String fixture = "three weeks ago";
        expectedException.expect(ParseException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_UnsupportedLiterals_NextYear() throws Exception{
        String fixture = "next year";
        expectedException.expect(ParseException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_UnsupportedLiterals_LastYear() throws Exception{
        String fixture = "last year";
        expectedException.expect(ParseException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_UnsupportedLiterals_LastNight() throws Exception{
        String fixture = "last night";
        expectedException.expect(ParseException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_UnsupportedLiterals_RandomString()throws Exception {
        String fixture = "#$%%^%&";
        expectedException.expect(ParseException.class);
        DateHelper.strToDate(fixture);
    }
}
