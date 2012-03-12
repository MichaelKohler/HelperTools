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
