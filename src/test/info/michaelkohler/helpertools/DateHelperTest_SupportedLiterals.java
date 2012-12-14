package info.michaelkohler.helpertools;

import info.michaelkohler.helpertools.date.DateHelper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class DateHelperTest_SupportedLiterals {
  @Test
  public void testStrToDate_Today() {
    String fixture = "today";
    Date actual = DateHelper.strToDate(fixture);
    Date expected = new Date();
    Assert.assertTrue(actual.equals(expected));
  }
  
  @Test
  public void testStrToDate_Yesterday() {
    String fixture = "yesterday";
    Date actual = DateHelper.strToDate(fixture);
    
    Calendar cal = new GregorianCalendar();
    cal.roll(Calendar.DATE, false);
    Date expected = cal.getTime();
    Assert.assertTrue(actual.equals(expected));
  }
  
  @Test
  public void testStrToDate_Tomorrow() {
    String fixture = "tomorrow";
    Date actual = DateHelper.strToDate(fixture);
    
    Calendar cal = new GregorianCalendar();
    cal.roll(Calendar.DATE, true);
    Date expected = cal.getTime();
    Assert.assertTrue(actual.equals(expected));
  }
}
