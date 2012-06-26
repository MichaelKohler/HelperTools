/* ============== HelperTools ==============
 * Initial developer: Michael Kohler <michaelkohler@live.com>
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

import org.junit.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import info.michaelkohler.helpertools.logging.Debugger;
import info.michaelkohler.helpertools.io.FileReader;

import java.io.File;
import java.io.IOException;

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
            String message = ex.getMessage();
            assertTrue("Failure: it's not a nullpointer exception", message.contains("null"));
        }        
    }

    @Test
    public void testErrorLog() throws IOException  {
        String test = null;
        try {
            test.toString();
        }
        catch (Exception ex) {
            Debugger.logMessage(ex);
            String loggedMessage = "";
            FileReader reader = new FileReader(Debugger.getLogFilename());
            loggedMessage = reader.readFile();

            boolean containsExceptionInfo = loggedMessage.contains("null");
            assertTrue("Failure: the logged message did not contain \"null\"..", containsExceptionInfo);
        }
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
