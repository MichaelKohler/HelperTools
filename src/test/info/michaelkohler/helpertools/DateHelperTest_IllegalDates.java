package info.michaelkohler.helpertools;

import info.michaelkohler.helpertools.date.DateHelper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DateHelperTest_IllegalDates {
  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void testStrToDate_20120532_IllegalDateInMay() {
    String fixture = "2012/05/33";
    expectedException.expect(RuntimeException.class);
    DateHelper.strToDate(fixture);
  }
  
  @Test
  public void testStrToDate_20120230_IllegalDateInFeb() {
    String fixture = "2012/02/30";
    expectedException.expect(RuntimeException.class);
    DateHelper.strToDate(fixture);
  }
  
  @Test
  public void testStrToDate_20120700_IllegalDateInJuly() {
    String fixture = "2012/07/00";
    expectedException.expect(RuntimeException.class);
    DateHelper.strToDate(fixture);
  }
  
  @Test
  public void testStrToDate_20120431_IllegalDateInApr() {
    String fixture = "2012/04/31";
    expectedException.expect(RuntimeException.class);
    DateHelper.strToDate(fixture);
  }
  
  @Test
  public void testStrToDate_20120031_IllegalZerothMonth() {
    String fixture = "2012/00/31";
    expectedException.expect(RuntimeException.class);
    DateHelper.strToDate(fixture);
  }
  
  @Test
  public void testStrToDate_20120031_IllegalThirteenthMonth() {
    String fixture = "2012/13/31";
    expectedException.expect(RuntimeException.class);
    DateHelper.strToDate(fixture);
  }
  
  @Test
  public void testStrToDate_20110229_NotALeapYear() {
    String fixture = "2011/02/29";
    expectedException.expect(RuntimeException.class);
    DateHelper.strToDate(fixture);
  }
}
