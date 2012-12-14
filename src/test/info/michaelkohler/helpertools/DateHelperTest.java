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
  
  @Test
  public void testStrToDate_18001213() {
    String fixture = "1800/12/13";
    Date actual = DateHelper.strToDate(fixture);
    Calendar cal = new GregorianCalendar(1800, 11, 13);
    Date expected = cal.getTime();
    Assert.assertTrue(actual.equals(expected));
  }
  
  @Test
  public void testStrToDate_18900330() {
    String fixture = "1890/03/30";
    Date actual = DateHelper.strToDate(fixture);
    Calendar cal = new GregorianCalendar(1890, 2, 30);
    Date expected = cal.getTime();
    Assert.assertTrue(actual.equals(expected));
  }
  
  @Test
  public void testStrToDate_17000215() {
    String fixture = "1700/02/15";
    Date actual = DateHelper.strToDate(fixture);
    Calendar cal = new GregorianCalendar(1700, 1, 15);
    Date expected = cal.getTime();
    Assert.assertTrue(actual.equals(expected));
  }
  
  @Test
  public void testStrToDate_17170605() {
    String fixture = "1717/06/25";
    Date actual = DateHelper.strToDate(fixture);
    Calendar cal = new GregorianCalendar(1717, 5, 25);
    Date expected = cal.getTime();
    Assert.assertTrue(actual.equals(expected));
  }
}
