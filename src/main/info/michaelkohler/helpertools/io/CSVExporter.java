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
package info.michaelkohler.helpertools.io;

import static info.michaelkohler.helpertools.tools.Validator.checkNotNull;
import info.michaelkohler.helpertools.logging.Debugger;

import java.io.IOException;

import javax.swing.JTable;

/**
 * The |CSVExporter| can be used to export different data
 * into a CSV file. It doesn't matter what you choose as source,
 * the resulting CSV file looks always the same.
 *
 * @author Michael Kohler
 * @version 0.0.2
 *
 */
public class CSVExporter {

    /**
     * The separator which should be used to separate the values.
     *
     * @see getSeparator()
     */
    private char separator;

    /**
     * The path where the resulting CSV file should be
     * placed.
     *
     * @see setCSVPath()
     */
    private String path;

    /**
     * Constructor which initializes an standard
     * |CSVExporter|.
     */
    public CSVExporter() {
    	
    }

    /**
     * Constructor which configures the specified
     * path for the CSV.
     *
     * @param aPath indicating the path for the CSV file
     */
    public CSVExporter(String aPath) {
        this.path = checkNotNull(aPath, "aPath cannot be null");
        this.separator = ';';
    }

    /**
     * Constructor which configures the specified
     * path for the CSV and the separator.
     *
     * @param aPath indicating the path for the CSV file
     * @param aSeparator indicating which separator should be used for the values
     */
    public CSVExporter(String aPath, char aSeparator) {
        this.path = checkNotNull(aPath, "aPath cannot be null");
        this.separator = aSeparator;
    }

    /**
     * Returns the separator used to separate values in the resulting file.
     *
     * @return separator used in the file
     */
    public final char getSeparator() {
        return this.separator;
    }

    /**
     * Sets the separator which should be used to separate values in the file.
     *
     * @param aSeparator used to separate values
     */
    public final void setSeparator(char aSeparator) {
        this.separator = aSeparator;
    }

    /**
     * Returns the current CSV file path.
     *
     * @return path to the CSV file
     */
    public final String getCSVPath() {
        return this.path;
    }

    /**
     * Sets the path to the CSV file.
     *
     * @param aPath path to the CSV file
     */
    public final void setCSVPath(String aPath) {
        this.path = checkNotNull(aPath, "aPath cannot be null");
    }

    /**
     * Exports all the data from a JTable into a CSV. Every cell
     * of the JTable is a entity in the CSV. Every line of the JTable
     * is a line in the CSV. You get the data as seen in the JTable.
     *
     * @param aTable to get the data from
     * @see #setSeparator(char)
     * @see javax.swing.JTable
     */
    public final void writeCSVFileFromJTable(JTable aTable) {
    	checkNotNull(aTable, "aTable cannot be null");
    	
        String fileContent = "";
        for (int i = 0; i < aTable.getRowCount(); i++) {
            for (int j = 0; j < aTable.getColumnCount(); j++) {
                // don't add separator on beginning
                if (j != 0) { fileContent += this.separator; }
                fileContent += "\"" + aTable.getModel().getValueAt(i, j) + "\"";
            }
            // don't add newline at the end of the file
            if (i != aTable.getRowCount() - 1) { fileContent += "\n"; }
        }

        FileWriter writer = new FileWriter(this.path, true);
        try {
            writer.writeFile(fileContent);
        } catch (IOException ex) {
            Debugger.logMessage(ex);
        }
    }


}
