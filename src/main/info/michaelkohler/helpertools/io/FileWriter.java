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
package info.michaelkohler.helpertools.io;

import static info.michaelkohler.helpertools.string.StringHelper.isNullOrEmpty;
import static info.michaelkohler.helpertools.tools.Validator.checkArgument;
import static info.michaelkohler.helpertools.tools.Validator.checkNotNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * A |FileWriter| writes data to a file.
 * Once a |FileWriter| is instantiated it can only
 * used for this path and this specific appending
 * option. If you need to write to an other file, you need
 * to create a new instance of the object.
 *
 * @author Michael Kohler
 * @version 0.0.2
 */
public class FileWriter {

    /**
     * Variable holding the path to the file to write to.
     */
    private final String path;

    /**
     * Variable whether we want to append the text to the file or override the content.
     */
    private final boolean append;

    /**
     * Constructor which sets the path and whether the
     * message should be appended to the file or not.
     *
     * @param aPath fully qualified path where we need to write the information to
     * @param aAppend whether the message should be appended or not
     */
    public FileWriter(String aPath, boolean aAppend) {
    	checkArgument(!isNullOrEmpty(aPath), "aPath cannot be null or empty");
        this.path = aPath;
        this.append = aAppend;
    }

    /**
     * Writes the specified text to the file specified in
     * the _path variable.
     *
     * @param aText which needs to be written to the file
     * @throws IOException if there was an error opening/accessing/writing to the file
     */
    public final void writeFile(String aText) throws IOException {
    	checkArgument(!isNullOrEmpty(aText), "text cannot be null or empty");
        java.io.FileWriter writer = new java.io.FileWriter(this.path, this.append);
        BufferedWriter out = new BufferedWriter(writer);
        out.write(aText);
        out.close();
        writer.close();
    }

    /**
     * Writes the specified stream to the file specified in
     * the _path variable.
     *
     * @param aStream stream which needs to be written to the file
     * @throws IOException if there was an error opening/accessing/writing to the file
     */
    public final void writeFile(InputStream aStream) throws IOException {
    	checkNotNull(aStream, "aStream cannot be null");
    	
        final int chunkSize = 1024;
        OutputStream out = new FileOutputStream(new File(this.path));
        int read = 0;
        byte[] bytes = new byte[chunkSize];
        while ((read = aStream.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        
        aStream.close();
        out.flush();
        out.close();
    }
}
