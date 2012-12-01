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
package info.michaelkohler.helpertools.logging;

import info.michaelkohler.helpertools.io.FileWriter;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * The |Debugger| can be use as a simple Exception logger.
 * It can just be used to log Exceptions to a specified file.
 *
 * @author Michael Kohler
 * @version 0.0.2
 */
public final class Debugger {

    /**
     * Filename of the error log file. This is just the file
     * name and NOT the full path.
     */
    private static String errorLogFilename = "error.log";

    /**
     * Private constructor since we don't want other classes
     * to instantiate this class.
     */
    private Debugger() {
    	throw new AssertionError("Cannot instantiate this class");
    }

    /**
     * Sets the error log's filename. This is just the file
     * name and NOT the full path.
     *
     * @param aFilename the error log filename (relative path)
     */
    public static void setLogFilename(String aFilename) {
        errorLogFilename = aFilename;
    }

    /**
     * Returns the error log's filename. This is just the file
     * name and NOT the full path.
     *
     * @return String representation of the error log filename
     */
    public static String getLogFilename() {
        return errorLogFilename;
    }

    /**
     * Logs the Exception in a error file. The Exception
     * is saved in full text, i.e. with StackTrace and date.
     *
     * @param ex Exception which needs to be logged
     */
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

    /**
     * Opens a FileWriter and writes the log to the file.
     * The file name of the log is taken from _errorLogFilename
     * which is defined in this class and can be set using the constructor.
     *
     * @param aLog which needs to be written
     */
    private static void writeLogFile(String aLog) {
        FileWriter writer = new FileWriter(errorLogFilename, true);
        try {
            writer.writeFile(aLog);
        } catch (IOException ex) {
            System.out.println("Could not save the stacktrace..");
        }
    }

    /**
     * Deletes the log file according to the variable defined for the
     * pass.
     *
     * @see #_errorLogFilename
     */
    public static void deleteLogFile() {
        File logFile = new File(errorLogFilename);
        if (logFile.exists())
            logFile.delete();
    }
}
