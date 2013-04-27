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
import info.michaelkohler.helpertools.io.FileReader;
import info.michaelkohler.helpertools.io.FileWriter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileReaderWriterTest  {
    
    private static String _path;
    private static boolean _append;
    private static String _message;


    @BeforeClass
    public static void initTest() {
        _path = "junittest.txt";
        _append = true;
        _message = "";
    }

    @Test
    public void testReaderWriterNormal() throws IOException {
        _append = false;
        _message = "blabla";
        FileWriter writer = new FileWriter(_path, _append);
        writer.writeFile(_message);
        FileReader reader = new FileReader(_path);
        String readText = reader.readFile();

        assertEquals("read text was not the written text..", _message + "\n", readText);
    }

    @Test
    public void testReaderWriterAppend() throws IOException {
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

    @Test(expected = IllegalArgumentException.class)
    public void testNullReaderConstructorArg() {
        new FileReader(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyReaderConstructorArg() {
        new FileReader("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNullWriterConstructorArg() {
        new FileWriter(null, true);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyWriterConstructorArg() {
        new FileWriter("", false);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNullStrWriteFile() throws IOException {
        FileWriter writer = new FileWriter(_path, _append);
        String s = null;
        writer.writeFile(s);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyWriteFile() throws IOException {
        FileWriter writer = new FileWriter(_path, _append);
        writer.writeFile("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNullInputWriteFile() throws IOException {
        FileWriter writer = new FileWriter(_path, _append);
        InputStream is = null;
        writer.writeFile(is);
    }
    
    @Test
    public void testReadLinesWithSuppliedCollection() throws IOException{
        _append = false;
        _message = "Hello!\nReadLines\n";
        
        FileWriter writer = new FileWriter(_path, _append);
        writer.writeFile(_message);
        
        FileReader reader = new FileReader(_path);
        List<String> lines = new ArrayList<String>(2);
        reader.readLines(lines);
        
        String[] splittedLines = _message.split("\\n");
        assertEquals("Number of lines must be equal to the number of lines in the message",splittedLines.length,lines.size());

        for(int i=0; i < splittedLines.length; i++){
            assertEquals("Elements must be equals", splittedLines[i], lines.get(i));
        }

    }
    
    @Test
    public void testReadLinesToList() throws IOException{
        _append = false;
        _message = "Hello!\nReadLines\n";
        
        FileWriter writer = new FileWriter(_path, _append);
        writer.writeFile(_message);
        
        FileReader reader = new FileReader(_path);
        List<String> lines = reader.readLines();
        
        String[] splittedLines = _message.split("\\n");
        assertEquals("Number of lines must be equal to the number of lines in the message",splittedLines.length,lines.size());

        for(int i=0; i < splittedLines.length; i++){
            assertEquals("Elements must be equals", splittedLines[i], lines.get(i));
        }
    }
    
    @After
    public void cleanup() {
        File file = new File(_path);
        file.delete();
    }
}
