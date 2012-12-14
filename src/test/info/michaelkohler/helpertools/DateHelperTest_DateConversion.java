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

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class DateHelperTest_DateConversion {

    @Test
    public void testStrToDate_NotNull() {
        String fixture = "2012/05/30";
        try {
            Date actual = DateHelper.strToDate(fixture);
            Assert.assertTrue(actual != null);
        } catch (ParseException e) {
            Assert.fail(e.getMessage());
        }
    }
    
    @Test
    public void testStrToDate_20120503() {
        Calendar cal = new GregorianCalendar(2012, 4, 30);
        Date expected = cal.getTime();
        
        String fixture = "2012/05/30";
        try{
            Date actual = DateHelper.strToDate(fixture);
            Assert.assertTrue(actual.equals(expected));
        } catch (ParseException e) {
            Assert.fail(e.getMessage());
        }
    }
    
    @Test
    public void testStrToDate_20130101() {
        Calendar cal = new GregorianCalendar(2013, 0, 1);
        Date expected = cal.getTime();
        
        String fixture = "2013/01/01";
        try{
            Date actual = DateHelper.strToDate(fixture);
            Assert.assertTrue(actual.equals(expected));
        } catch (ParseException e) {
            Assert.fail(e.getMessage());
        }
    }
    
    @Test
    public void testStrToDate_19700531() {
        Calendar cal = new GregorianCalendar(1970, 4, 31);
        Date expected = cal.getTime();
        
        String fixture = "1970/05/31";
        try{
            Date actual = DateHelper.strToDate(fixture);
            Assert.assertTrue(actual.equals(expected));
        } catch (ParseException e) {
            Assert.fail(e.getMessage());
        }
    }
    
    @Test
    public void testStrToDate_18001213() {
        Calendar cal = new GregorianCalendar(1800, 11, 13);
        Date expected = cal.getTime();
        
        String fixture = "1800/12/13";
        try{
            Date actual = DateHelper.strToDate(fixture);
            Assert.assertTrue(actual.equals(expected));
        } catch (ParseException e) {
            Assert.fail(e.getMessage());
        }
    }
    
    @Test
    public void testStrToDate_18900330() {
        Calendar cal = new GregorianCalendar(1890, 2, 30);
        Date expected = cal.getTime();
        
        String fixture = "1890/03/30";
        try{
            Date actual = DateHelper.strToDate(fixture);
            Assert.assertTrue(actual.equals(expected));
        } catch (ParseException e) {
            Assert.fail(e.getMessage());
        }
    }
    
    @Test
    public void testStrToDate_17000215() {
        Calendar cal = new GregorianCalendar(1700, 1, 15);
        Date expected = cal.getTime();
        
        String fixture = "1700/02/15";
        try{
            Date actual = DateHelper.strToDate(fixture);
            Assert.assertTrue(actual.equals(expected));
        } catch (ParseException e) {
            Assert.fail(e.getMessage());
        }
    }
    
    @Test
    public void testStrToDate_17170605() {
        Calendar cal = new GregorianCalendar(1717, 5, 25);
        Date expected = cal.getTime();
        
        String fixture = "1717/06/25";
        try{
            Date actual = DateHelper.strToDate(fixture);
            Assert.assertTrue(actual.equals(expected));
        }  catch (ParseException e) {
            Assert.fail(e.getMessage());
        }
    }
}
