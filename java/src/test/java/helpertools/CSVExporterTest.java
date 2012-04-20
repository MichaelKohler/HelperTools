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

import helpertools.CSVExporter;
import helpertools.FileReader;

import java.io.File;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class CSVExporterTest  {

    public static String _message;
    public static String _path;

    @BeforeClass
    public static void initTest() {
        _message = "";
        _path = "test.csv";
    }

    @Test
    public void getFileNameShouldReturnTheCorrectPath() {
        String path = "testpath.csv";
        CSVExporter exporter = new CSVExporter(path);
        assertEquals("Failure: the path was not correct..", path, exporter.getCSVPath());
    }

    @Test
    public void setFileNameShouldSetTheCorrectPath() {
        String path = "new_test_path.csv";
        CSVExporter exporter = new CSVExporter();
        exporter.setCSVPath(path);
        assertEquals("Failure: the set path was not the one we retrieved..", path, exporter.getCSVPath());
    }

    @Ignore
    public void testFileWriteCapabilityFromTable() {
        
    }

    @Ignore
    public void testFileContentFormat() {
        
    }

    @AfterClass
    public static void cleanup() {
        File testCSV = new File(_path);
        testCSV.delete();
    }


}
