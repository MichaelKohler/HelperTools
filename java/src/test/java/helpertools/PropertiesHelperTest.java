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
        PropertiesHelper.setPropertyFilename(_filename);
        PropertiesHelper.setProperty(_key, _testString);
        String readString = PropertiesHelper.getProperty(_key);
        assertEquals("Failure: original string was not the restored string...", _testString, readString);
    }

    @Test
    public void shouldRemoveProperties() {
        PropertiesHelper.setPropertyFilename(_filename);
        PropertiesHelper.removeProperty(_key);
        boolean keyExists = PropertiesHelper.propertyExists(_key);
        assertNotNull("property was null", keyExists);
        assertFalse("Failure: property was still there", keyExists);
    }

    @Test
    public void shouldGetPropertiesFilename() {
        PropertiesHelper.setPropertyFilename(_filename);
        String returnedFilename = PropertiesHelper.getPropertyFilename();
        assertEquals("Failure: returned filename was not " + _filename + "...", _filename, returnedFilename);
    }

    @Test
    public void shouldDeleteSettingsFile() {
        PropertiesHelper.setPropertyFilename(_filename);
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
