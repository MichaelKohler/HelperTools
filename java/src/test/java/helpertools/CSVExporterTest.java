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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class CSVExporterTest  {

    public static String _message;
    public static String _path;

    public CSVExporterTest() {
    }

    @BeforeClass
    public static void initTest() {
        _message = "[Date] username: textfoobar\n[Date2] username2: text2";
        _path = "test.csv";
    }

    @Ignore
    public void testFileWriteCapability()  {
        CSVExporter exp = new CSVExporter(_path);
        exp.writeLogFile(_message);
        assertNotNull("exporter could not been initialized..", exp);
    }

    @Ignore
    public void testFileContentFormat() {
        FileReader reader = new FileReader(_path);
        String readCSV = reader.readFile();
        String expected = "\"Date\";\"username\"; \"textfoobar\"\n\"Date2\";\"username2\"; \"text2\"\n";
        assertEquals("the read string was not as expected..", expected, readCSV);
    }

    @After
    public void cleanup() {
        File testCSV = new File(_path);
        testCSV.delete();
    }


}
