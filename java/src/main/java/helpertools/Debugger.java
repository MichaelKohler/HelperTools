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

import java.io.File;
import java.util.Date;

public class Debugger {

    private static String _errorLogFilename = "error.log";

    public Debugger() {

    }

    public static String getLogFilename() {
        return _errorLogFilename;
    }

    public static void logMessage(Exception ex) {
        System.out.println("Message: " + ex.getMessage() + "....\n");
        System.out.println("Stacktrace: ");
        StackTraceElement[] ste = ex.getStackTrace();

        String log = "\n" + new Date().toString() + ":\n";
        log += ex.getMessage() + "\n";
        for (int i = 0; i < ste.length; i++) {
            System.out.println(ste[i]);
            log += ste[i] + "\n";
        }
        log += "\n\n===========";

        writeLogFile(log);
    }

    private static void writeLogFile(String aLog) {
        FileWriter writer = new FileWriter(_errorLogFilename, true);
        writer.writeFile(aLog);
    }

    public static void deleteLogFile() {
        File logFile = new File(_errorLogFilename);
        if (logFile.exists())
            logFile.delete();
    }
}
