package info.michaelkohler.helpertools;

import info.michaelkohler.helpertools.date.DateHelper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class DateHelperTest_ConvenientDates {
  @Test
    public void testGetTodayDate() {
        Date expected = new Date();
        Date actual = DateHelper.todayDate();
        Assert.assertTrue(compareDatesToTheMinutes(actual, expected));
    }
    
    @Test
    public void testGetYesterdayDate() {
        Calendar cal = new GregorianCalendar();
        cal.roll(Calendar.DATE, false);
        Date expected = cal.getTime();
        
        Date actual = DateHelper.yesterdayDate();
        Assert.assertTrue(compareDatesToTheMinutes(actual, expected));
    }
    
    @Test
    public void testGetTomorrowDate() {
        Calendar cal = new GregorianCalendar();
        cal.roll(Calendar.DATE, true);
        Date expected = cal.getTime();
        
        Date actual = DateHelper.tomorrowDate();
        Assert.assertTrue(compareDatesToTheMinutes(actual, expected));
    }
    
    private boolean compareDatesToTheMinutes(Date obj1, Date obj2){
        Calendar cal1 = new GregorianCalendar();
        cal1.setTimeInMillis(obj1.getTime());
        Calendar cal2 = new GregorianCalendar();
        cal2.setTimeInMillis(obj2.getTime());
        
        return (cal1.get(Calendar.DATE) == cal2.get(Calendar.DATE) 
             && cal1.get(Calendar.HOUR) == cal2.get(Calendar.HOUR)
             && cal1.get(Calendar.MINUTE) == cal2.get(Calendar.MINUTE)
             && cal1.get(Calendar.SECOND) == cal2.get(Calendar.SECOND));
    }
}
