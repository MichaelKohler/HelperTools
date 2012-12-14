package info.michaelkohler.helpertools;

import info.michaelkohler.helpertools.date.DateHelper;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class DateHelperTest_SupportedLiterals {
    @Test
    public void testStrToDate_Today() {
        Date expected = new Date();
        
        String fixture = "today";
        try{
            Date actual = DateHelper.strToDate(fixture);
            Assert.assertTrue(actual.equals(expected));
        } catch(ParseException e){
            Assert.fail(e.getMessage());
        }
    }
    
    @Test
    public void testStrToDate_Yesterday() {
        Calendar cal = new GregorianCalendar();
        cal.roll(Calendar.DATE, false);
        Date expected = cal.getTime();
        
        String fixture = "yesterday";
        try{
            Date actual = DateHelper.strToDate(fixture);
            Assert.assertTrue(actual.equals(expected));
        } catch(ParseException e){
            Assert.fail(e.getMessage());
        }
    }
    
    @Test
    public void testStrToDate_Tomorrow() {
        Calendar cal = new GregorianCalendar();
        cal.roll(Calendar.DATE, true);
        Date expected = cal.getTime();
        
        String fixture = "tomorrow";
        try{
            Date actual = DateHelper.strToDate(fixture);
            Assert.assertTrue(actual.equals(expected));
        } catch(ParseException e){
            Assert.fail(e.getMessage());
        }
    }
}
