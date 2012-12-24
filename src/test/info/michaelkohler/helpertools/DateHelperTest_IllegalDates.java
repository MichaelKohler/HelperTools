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

import info.michaelkohler.helpertools.date.DateFormatHelper;

import java.text.ParseException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DateHelperTest_IllegalDates {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testStrToDate_20120532_IllegalDateInMay() throws Exception{
        String fixture = "2012/05/33";  
        expectedException.expect(ParseException.class);
        DateFormatHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_20120230_IllegalDateInFeb()  throws Exception{
        String fixture = "2012/02/30";
        expectedException.expect(ParseException.class);
        DateFormatHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_20120700_IllegalDateInJuly()  throws Exception{
        String fixture = "2012/07/00";
        expectedException.expect(ParseException.class);
        DateFormatHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_20120431_IllegalDateInApr()  throws Exception{
        String fixture = "2012/04/31";
        expectedException.expect(ParseException.class);
        DateFormatHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_20120031_IllegalZerothMonth() throws Exception {
        String fixture = "2012/00/31";
        expectedException.expect(ParseException.class);
        DateFormatHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_20120031_IllegalThirteenthMonth() throws Exception{
        String fixture = "2012/13/31";
        expectedException.expect(ParseException.class);
        DateFormatHelper.strToDate(fixture);
    }
    
    @Test
    public void testStrToDate_20110229_NotALeapYear() throws Exception {
        String fixture = "2011/02/29";
        expectedException.expect(ParseException.class);
        DateFormatHelper.strToDate(fixture);
    }
}
