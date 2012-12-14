package info.michaelkohler.helpertools;

import info.michaelkohler.helpertools.date.DateHelper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DateHelperTest_UnsupportedLiterals {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testStrToDate_UnsupportedLiterals_TwoDaysAgo() {
        String fixture = "two days ago";
        expectedException.expect(RuntimeException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_UnsupportedLiterals_OneMonthAgo() {
        String fixture = "one month ago";
        expectedException.expect(RuntimeException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_UnsupportedLiterals_FiveDaysLater() {
        String fixture = "five days later";
        expectedException.expect(RuntimeException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_UnsupportedLiterals_ThreeWeeksAgo() {
        String fixture = "three weeks ago";
        expectedException.expect(RuntimeException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_UnsupportedLiterals_NextYear() {
        String fixture = "next year";
        expectedException.expect(RuntimeException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_UnsupportedLiterals_LastYear() {
        String fixture = "last year";
        expectedException.expect(RuntimeException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_UnsupportedLiterals_LastNight() {
        String fixture = "last night";
        expectedException.expect(RuntimeException.class);
        DateHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_UnsupportedLiterals_RandomString() {
        String fixture = "#$%%^%&";
        expectedException.expect(RuntimeException.class);
        DateHelper.strToDate(fixture);
    }
}
