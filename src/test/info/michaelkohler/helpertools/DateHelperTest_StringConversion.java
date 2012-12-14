package info.michaelkohler.helpertools;

import info.michaelkohler.helpertools.date.DateHelper;
import info.michaelkohler.helpertools.string.StringHelper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class DateHelperTest_StringConversion {
  @Test
  public void testDateToStr_NotNull() {
    Date fixture = new Date();
    String actual = DateHelper.dateToStr(fixture);
    Assert.assertNotNull(actual);
  }
  
  @Test
  public void testDateToStr_NotEmpty() {
    Date fixture = new Date();
    String actual = DateHelper.dateToStr(fixture);
    Assert.assertTrue(!StringHelper.isNullOrEmpty(actual));
  }
  
  @Test
  public void testDateToStr_20120512() {
    String expected = "2012/05/12";
    Calendar cal = new GregorianCalendar(2012, 4, 12);
    Date fixture = cal.getTime();
    String actual = DateHelper.dateToStr(fixture);
    Assert.assertTrue(actual.equals(expected));
  }
}
