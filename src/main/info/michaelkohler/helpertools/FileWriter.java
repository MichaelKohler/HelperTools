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

import java.io.BufferedWriter;

/**
 * A |FileWriter| writes data to a file.
 * Once a |FileWriter| is instanciated it can only
 * used for this path and this specific appending
 * option. If you need to write to an other file, you need
 * to create a new instance of the object.
 * 
 * @author Michael Kohler
 * @version 0.0.1
 */
public class FileWriter {

    private String _path;
    private boolean _append;

    /**
     * Constructor which sets the path and whether the
     * message should be appended to the file or not.
     * 
     * @param full qualified path where we need to write the information to
     * @param whether the message should be appended or not
     */
    public FileWriter(String aPath, boolean aAppend) {
        _path = aPath;
        _append = aAppend;
    }

    /**
     * Writes the specified text to the file specified in
     * the _path variable.
     * 
     * @param aText which needs to be written to the file
     */
    public void writeFile(String aText) {
        try {
            java.io.FileWriter writer = new java.io.FileWriter(_path, _append);
            BufferedWriter out = new BufferedWriter(writer);
            out.write(aText);
            out.close();
        } catch (Exception ex) {
        }
    }

}
