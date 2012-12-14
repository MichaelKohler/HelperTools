package info.michaelkohler.helpertools;

import info.michaelkohler.helpertools.date.DateHelper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class DateHelperTest {

  @Test
  public void testStrToDate_NotNull() {
    String fixture = "2012/05/30";
    Date actual = DateHelper.strToDate(fixture);
    Assert.assertTrue(actual != null);
  }
  
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
  
  @Test
  public void testStrToDate_20120503() {
    String fixture = "2012/05/30";
    Date actual = DateHelper.strToDate(fixture);
    Calendar cal = new GregorianCalendar(2012, 4, 30);
    Date expected = cal.getTime();
    Assert.assertTrue(actual.equals(expected));
  }
  
  @Test
  public void testStrToDate_20130101() {
    String fixture = "2013/01/01";
    Date actual = DateHelper.strToDate(fixture);
    Calendar cal = new GregorianCalendar(2013, 0, 1);
    Date expected = cal.getTime();
    Assert.assertTrue(actual.equals(expected));
  }
  
  @Test
  public void testStrToDate_19700531() {
    String fixture = "1970/05/31";
    Date actual = DateHelper.strToDate(fixture);
    Calendar cal = new GregorianCalendar(1970, 4, 31);
    Date expected = cal.getTime();
    Assert.assertTrue(actual.equals(expected));
  }
}
