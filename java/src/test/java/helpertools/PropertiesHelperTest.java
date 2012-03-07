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

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import helpertools.PropertiesHelper;

import java.io.File;

public class PropertiesHelperTest  {
    private static String _testString;
    private static String _key;
    private static String _filename;

    public PropertiesHelperTest() {
    }

    @BeforeClass
    public static void initTest() {
        _testString = "TestString";
        _key = "testKey";
	_filename = "settings.properties";
    }

    @Test
    public void shouldReadAndWriteProperties() {
        PropertiesHelper.setProperty(_key, _testString);
        String readString = PropertiesHelper.getProperty(_key);
        assertEquals("Failure: original string was not the restored string...", _testString, readString);
    }

    @Test
    public void shouldRemoveProperties() {
        PropertiesHelper.removeProperty(_key);
        boolean keyExists = PropertiesHelper.propertyExists(_key);
        assertNotNull("property was null", keyExists);
        assertFalse("Failure: property was still there", keyExists);
    }

    @Test
    public void shouldGetPropertiesFilename() {
        String returnedFilename = PropertiesHelper.getPropertyFilename();
        assertEquals("Failure: returned filename was not " + _filename + "...", _filename, returnedFilename);
    }

    @Test
    public void shouldDeleteSettingsFile() {
        PropertiesHelper.deleteSettingsFile();
        File settingsFile = new File(_filename);
        assertFalse("Failure: settings file is still existent!", settingsFile.exists());
    }

    @AfterClass
    public static void cleanup() {
        File settingsFile = new File(_filename);
        if (settingsFile.exists())
            settingsFile.delete();
    }
}
