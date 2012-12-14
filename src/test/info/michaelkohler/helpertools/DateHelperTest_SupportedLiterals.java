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
