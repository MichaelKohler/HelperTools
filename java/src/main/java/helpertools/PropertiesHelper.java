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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

    private static Properties _props;
    private static String _propertyFileName = "settings.properties";
    private static String _propertyFile;

    public PropertiesHelper() {
    }

    public static String getPropertyFilename() {
        return _propertyFileName;
    }

    private static void loadPropertiesFile() {
        String currentDir = new File("").getAbsolutePath();
        _propertyFile = currentDir + "/" + _propertyFileName;
	File propFile = new File(_propertyFile);
	try {
	    propFile.createNewFile();
        } catch (IOException ex) {
	}

        _props = new Properties();
         try {
            _props.load(new FileInputStream(_propertyFile));
        } catch (IOException ex) {
            Debugger.logMessage(ex);
        }
    }

    public static void setProperty(String aKey, String aValue) {
        loadPropertiesFile();
        _props.setProperty(aKey, aValue);
        storePropsFile();
    }

    public static String getProperty(String aKey) {
        loadPropertiesFile();
        String propValue = "";
        propValue = _props.getProperty(aKey);
        return propValue;
    }

    public static boolean propertyExists(String aKey) {
        loadPropertiesFile();
        boolean exists = _props.containsKey(aKey);
        return exists;
    }

    public static void removeProperty(String aKey) {
        loadPropertiesFile();
        if (_props.containsKey(aKey))
            _props.remove(aKey);
        storePropsFile();
    }

    public static void storePropsFile() {
        try {
            _props.store(new FileOutputStream(_propertyFile), null);
        } catch (IOException ex) {
            Debugger.logMessage(ex);
        }
    }

    public static void deleteSettingsFile() {
        File settingsFile = new File(_propertyFileName);
        if (settingsFile.exists())
            settingsFile.delete();
    }
}
