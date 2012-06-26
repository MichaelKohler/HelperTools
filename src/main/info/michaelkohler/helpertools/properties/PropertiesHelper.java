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
package info.michaelkohler.helpertools.properties;

import info.michaelkohler.helpertools.logging.Debugger;

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
 * @version 0.0.2
 */
public final class PropertiesHelper {

    /**
     * The Properties instance we use internally.
     */
    private static Properties props;

    /**
     * Filename of the Properties file. This is NOT
     * the full qualified path, but just the filename!
     * It can be set using the setPropertyFilename()
     * method.
     *
     * @see setPropertyFilename()
     */
    private static String propertyFileName;

    /**
     * The Properties file which is stored on the
     * hard drive.
     */
    private static String propertyFile;

    /**
     * Private constructor since we don't want other classes
     * to instantiate this class.
     */
    private PropertiesHelper() {
    }

    /**
     * Returns the filename of the Properties file. This is just the
     * file name and not the path!
     *
     * @return filename under which the Properties file is saved
     */
    public static String getPropertyFilename() {
        if (propertyFileName == null)
            setPropertyFilename("");
        return propertyFileName;
    }

    /**
     * Sets the filename of the Properties file. This is just the
     * file name and not the path!
     *
     * @param aFileName of the Properties file
     */
    public static void setPropertyFilename(String aFileName) {
        propertyFileName = aFileName;
    }

    /**
     * Loads the Properties file into memory so we can
     * edit it.
     */
    private static void loadPropertiesFile() {
        String currentDir = new File("").getAbsolutePath();
        propertyFile = currentDir + "/" + propertyFileName;
        File propFile = new File(propertyFile);
        try {
            propFile.createNewFile();
        } catch (IOException ex) {
            Debugger.logMessage(ex);
        }

        props = new Properties();
        try {
            FileInputStream fis = new FileInputStream(propertyFile);
            props.load(fis);
            fis.close();
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
        props.setProperty(aKey, aValue);
        storePropsFile();
    }

    /**
     * Returns the value of a Property.
     *
     * @param aKey of the Property
     * @return the value of the Property
     */
    public static String getProperty(String aKey) {
        loadPropertiesFile();
        String propValue = "";
        propValue = props.getProperty(aKey);
        return propValue;
    }

    /**
     * Checks whether a given Property exists or not.
     *
     * @param aKey of the requested Property
     * @return whether the Property exists or not - This is just the
     *              file name and not the path!
     */
    public static boolean propertyExists(String aKey) {
        loadPropertiesFile();
        boolean exists = props.containsKey(aKey);
        return exists;
    }

    /**
     * Removes a Property from the Properties file.
     *
     * @param aKey of the Property to remove
     */
    public static void removeProperty(String aKey) {
        loadPropertiesFile();
        if (props.containsKey(aKey))
            props.remove(aKey);
        storePropsFile();
    }

    /**
     * Stores the Property file. This method has to be called
     * after modifying any Properties. This is automatically
     * done.
     */
    private static void storePropsFile() {
        try {
            FileOutputStream fos = new FileOutputStream(propertyFile);
            props.store(fos, null);
            fos.close();
        } catch (IOException ex) {
            Debugger.logMessage(ex);
        }
    }

    /**
     * Deletes the Properties file given by the specified
     * Properties file name.
     */
    public static void deleteSettingsFile() {
        File settingsFile = new File(propertyFileName);
        if (settingsFile.exists())
            settingsFile.delete();
    }
}
