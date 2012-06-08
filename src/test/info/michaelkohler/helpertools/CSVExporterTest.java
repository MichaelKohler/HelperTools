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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import info.michaelkohler.helpertools.io.CSVExporter;
import info.michaelkohler.helpertools.io.FileReader;

import java.io.File;

import javax.swing.JTable;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CSVExporterTest  {

    public static String _message;
    public static String _path;
    public static CSVExporter _exporter;
    public static CSVExporter _exporterWithDefaultPath;

    @BeforeClass
    public static void initTest() {
        _message = "";
        _path = "test.csv";
        _exporter = new CSVExporter();
        _exporterWithDefaultPath = new CSVExporter(_path);
    }

    @Test
    public void getFileNameShouldReturnTheCorrectPath() {
        assertEquals("Failure: the path was not correct..", _path, _exporterWithDefaultPath.getCSVPath());
    }

    @Test
    public void setFileNameShouldSetTheCorrectPath() {
        String newPath = _path + "_bak";
        _exporter.setCSVPath(newPath);
        assertEquals("Failure: the set path was not the one we retrieved..", newPath, _exporter.getCSVPath());
    }

    @Test
    public void testFileWriteCapabilityFromTable() {
        Object[][] data = {
                { "foo", new Integer(6) },
                { "bar", new Integer(10) }
        };
        String[] columnNames = { "Test1", "Test2" };
        JTable table = new JTable(data, columnNames);
        assertTrue("Data is inconsistent!", table.getRowCount() == 2 && table.getColumnCount() == 2);
        
        _exporter.setCSVPath(_path);
        _exporter.setSeparator(';');
        _exporter.writeCSVFileFromJTable(table);
        char separator = _exporter.getSeparator();
        String fileContent = new FileReader(_path).readFile();
        String expectedContent = "\"foo\"" + separator + "\"6\"\n\"bar\"" + separator + "\"10\"\n";
        assertEquals("Wrong content in CSV file!", expectedContent, fileContent);
    }

    @AfterClass
    public static void cleanup() {
        File testCSV = new File(_path);
        testCSV.delete();
    }


}
