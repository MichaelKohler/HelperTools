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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The |PropertiesHelper| is a full API for Java's
 * Properties. It supports every action you can
 * do with Properties.
 * 
 * @author Michael Kohler
 * @version 0.0.1
 */
public class PropertiesHelper {

    /**
     * The Properties instance we use internally.
     */
    private static Properties _props;

    /**
     * Filename of the Properties file. This is NOT
     * the full qualified path, but just the filename!
     * It can be set using the setPropertyFilename()
     * method.
     * 
     * @see setPropertyFilename()
     */
    private static String _propertyFileName;

    /**
     * The Properties file which is stored on the
     * hard drive.
     */
    private static String _propertyFile;

    /**
     * Empty Constructor
     */
    public PropertiesHelper() {
    }

    /**
     * Returns the filename of the Properties file. This is just the
     * file name and not the path!
     * 
     * @return filename under which the Properties file is saved
     */
    public static String getPropertyFilename() {
        if (_propertyFileName == null)
            setPropertyFilename("");
        return _propertyFileName;
    }

    /**
     * Sets the filename of the Properties file. This is just the
     * file name and not the path!
     * 
     * @param aFileName of the Properties file
     */
    public static void setPropertyFilename(String aFileName) {
        _propertyFileName = aFileName;
    }

    /**
     * Loads the Properties file into memory so we can
     * edit it.
     */
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

    /**
     * Sets a Property.
     * 
     * @param aKey of the Property
     * @param aValue of the Property
     */
    public static void setProperty(String aKey, String aValue) {
        loadPropertiesFile();
        _props.setProperty(aKey, aValue);
        storePropsFile();
    }

    /**
     * Returns the value of a Property.
     * 
     * @param aKey of the Property
     * @return
     */
    public static String getProperty(String aKey) {
        loadPropertiesFile();
        String propValue = "";
        propValue = _props.getProperty(aKey);
        return propValue;
    }

    /**
     * Checks whether a given Property exists or not
     * 
     * @param aKey of the requested Property
     * @return whether thThis is just the
     * file name and not the path!e Property exists or not
     */
    public static boolean propertyExists(String aKey) {
        loadPropertiesFile();
        boolean exists = _props.containsKey(aKey);
        return exists;
    }

    /**
     * Removes a Property from the Properties file
     * 
     * @param aKey of the Property to remove
     */
    public static void removeProperty(String aKey) {
        loadPropertiesFile();
        if (_props.containsKey(aKey))
            _props.remove(aKey);
        storePropsFile();
    }

    /**
     * Stores the Property file. This method has to be called
     * after modifying any Properties. This is automatically
     * done.
     */
    private static void storePropsFile() {
        try {
            _props.store(new FileOutputStream(_propertyFile), null);
        } catch (IOException ex) {
            Debugger.logMessage(ex);
        }
    }

    /**
     * Deletes the Properties file given by the specified
     * Properties file name.
     */
    public static void deleteSettingsFile() {
        File settingsFile = new File(_propertyFileName);
        if (settingsFile.exists())
            settingsFile.delete();
    }
}
