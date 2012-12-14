/* ============== HelperTools ==============
 * Initial developer: Ivan Sim <ihcsim@gmail.com>
 *
 * =====
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE - Version 2
 *
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 *
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 * TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 * 0. You just DO WHAT THE FUCK YOU WANT TO.
 *
 * =====
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND.
 *
 */
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
    
    @Test
    public void testDateToStr_20121212() {
        String expected = "2012/12/12";
        Calendar cal = new GregorianCalendar(2012, 11, 12);
        Date fixture = cal.getTime();
        String actual = DateHelper.dateToStr(fixture);
        Assert.assertTrue(actual.equals(expected));
    }
    
    @Test
    public void testDateToStr_20101010() {
        String expected = "2010/10/10";
        Calendar cal = new GregorianCalendar(2010, 9, 10);
        Date fixture = cal.getTime();
        String actual = DateHelper.dateToStr(fixture);
        Assert.assertTrue(actual.equals(expected));
    }
    
    @Test
    public void testDateToStr_20050131() {
        String expected = "2005/01/31";
        Calendar cal = new GregorianCalendar(2005, 0, 31);
        Date fixture = cal.getTime();
        String actual = DateHelper.dateToStr(fixture);
        Assert.assertTrue(actual.equals(expected));
    }
}
