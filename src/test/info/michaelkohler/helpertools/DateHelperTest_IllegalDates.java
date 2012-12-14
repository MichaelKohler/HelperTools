package info.michaelkohler.helpertools;

import info.michaelkohler.helpertools.date.DateHelper;

import java.text.ParseException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DateHelperTest_IllegalDates {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testStrToDate_20120532_IllegalDateInMay() throws Exception{
        String fixture = "2012/05/33";  
        expectedException.expect(ParseException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_20120230_IllegalDateInFeb()  throws Exception{
        String fixture = "2012/02/30";
        expectedException.expect(ParseException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_20120700_IllegalDateInJuly()  throws Exception{
        String fixture = "2012/07/00";
        expectedException.expect(ParseException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_20120431_IllegalDateInApr()  throws Exception{
        String fixture = "2012/04/31";
        expectedException.expect(ParseException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_20120031_IllegalZerothMonth() throws Exception {
        String fixture = "2012/00/31";
        expectedException.expect(ParseException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_20120031_IllegalThirteenthMonth() throws Exception{
        String fixture = "2012/13/31";
        expectedException.expect(ParseException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_20110229_NotALeapYear() throws Exception {
        String fixture = "2011/02/29";
        expectedException.expect(ParseException.class);
        DateHelper.strToDate(fixture);
    }
}
