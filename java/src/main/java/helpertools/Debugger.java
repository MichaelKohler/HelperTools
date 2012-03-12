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
