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

    @Test
    public void testFileWriteCapability()  {
        CSVExporter exp = new CSVExporter(_path);
        exp.writeLogFile(_message);
        assertNotNull("exporter could not been initialized..", exp);
    }

    @Test
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
