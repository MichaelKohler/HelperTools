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

import javax.swing.JTable;

/**
 * The |CSVExporter| can be used to export different data
 * into a CSV file. It doesn't matter what you choose as source,
 * the resulting CSV file looks always the same.
 * 
 * @author Michael Kohler
 * @version 0.0.1a
 *
 */
public class CSVExporter {

    /**
     * The path where the resulting CSV file should be
     * placed.
     * 
     * @see setCSVPath()
     */
    private String _path;

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
        _path = aPath;
    }

    /**
     * Returns the current CSV file path.
     * 
     * @return path to the CSV file
     */
    public String getCSVPath() {
        return _path;
    }

    /**
     * Sets the path to the CSV file.
     * 
     * @param path to the CSV file
     */
    public void setCSVPath(String aPath) {
        _path = aPath;
    }

    /**
     * Exports all the data from a JTable into a CSV. Every cell
     * of the JTable is a entity in the CSV. Every line of the JTable
     * is a line in the CSV. You get the data as seen in the JTable.
     * 
     * @param JTable to get the data from
     * @see javax.swing.JTable
     */
    public void writeCSVFileFromJTable(JTable aTable) {

    }


}
