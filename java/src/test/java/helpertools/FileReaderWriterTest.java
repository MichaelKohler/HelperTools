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

import helpertools.FileReader;
import helpertools.FileWriter;

import java.io.File;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class FileReaderWriterTest  {
    private static String _path;
    private static boolean _append;
    private static String _message;

    public FileReaderWriterTest() {
    }

    @BeforeClass
    public static void initTest() {
        _path = "junittest.txt";
        _append = true;
        _message = "";
    }

    @Test
    public void testReaderWriterNormal() {
        _append = false;
        _message = "blabla";
        FileWriter writer = new FileWriter(_path, _append);
        writer.writeFile(_message);
        FileReader reader = new FileReader(_path);
        String readText = reader.readFile();

        assertEquals("read text was not the written text..", _message + "\n", readText);
    }

    @Test
    public void testReaderWriterAppend() {
        _append = true;
        _message = "blabla";
        FileWriter writer = new FileWriter(_path, _append);
        writer.writeFile(_message);
        String secondLine = "secondline";
        FileWriter secondWriter = new FileWriter(_path, _append);
        secondWriter.writeFile(secondLine);

        FileReader reader = new FileReader(_path);
        String readText = reader.readFile();

        _message += secondLine + "\n";
        assertEquals("read text was not the written text..", _message, readText);
    }

    @After
    public void cleanup() {
        File file = new File(_path);
        file.delete();
    }

}
