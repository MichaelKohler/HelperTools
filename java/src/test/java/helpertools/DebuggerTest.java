/* ============== HelperTools ==============
 * Copyright 2012 by Michael Kohler
 *
 * Initial developer: Michael Kohler <michaelkohler@live.com>
 *
 * Contributors:
 *
 * ============== MIT License ==============
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package helpertools;

import org.junit.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import helpertools.Debugger;
import helpertools.FileReader;

import java.io.File;

public class DebuggerTest  {
    public static Object _nullObject;;

    public DebuggerTest() {
    }

    @BeforeClass
    public static void initTest() {
        _nullObject = null;
    }

    @Test (expected=NullPointerException.class)
    public void testDebugger() {
        assertNull("Failure: object was not null..", _nullObject);
        try {
            _nullObject.toString();
        }
        catch (Exception ex) {
             Debugger.logMessage(ex);

            String message = ex.getMessage();
            assertTrue("Failure: it's not a nullpointer exception", message.contains("null"));
        }        
    }

    @Test
    public void testErrorLog()  {
        String loggedMessage = "";

        FileReader reader = new FileReader(Debugger.getLogFilename());
        loggedMessage = reader.readFile();

        boolean containsExceptionInfo = loggedMessage.contains("null");
        assertTrue("Failure: the logged message did not contain \"null\"..", containsExceptionInfo);
    }

    @Test
    public void shouldDeleteLog() {
	Debugger.deleteLogFile();
	File logFile = new File(Debugger.getLogFilename());
        assertFalse("Failure: log file was still existent!", logFile.exists());
    }

    @AfterClass
    public static void cleanup() {
        File logFile = new File(Debugger.getLogFilename());
        if (logFile.exists())
	    logFile.delete();
    }
}
