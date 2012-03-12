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

import java.io.BufferedWriter;

public class FileWriter {

    private String _path;
    private boolean _append;
    public FileWriter(String aPath, boolean aAppend) {
        _path = aPath;
        _append = aAppend;
    }

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
