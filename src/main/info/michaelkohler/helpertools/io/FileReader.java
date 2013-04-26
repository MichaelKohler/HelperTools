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
import info.michaelkohler.helpertools.tools.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * The |FileReader| is responsible to read the content of
 * a whole file. It returns the content as a String.
 *
 * @author Michael Kohler, Victor Reventos
 * @version 0.0.3
 */
public class FileReader {

    /**
     * Path to the file which needs to be read. This is not just
     * the file name, but the full qualified path.
     */
    private final String path;

    /**
     * Constructor which sets the specified path to the
     * _path variable.
     *
     * @param aPath to the file to be read
     */
    public FileReader(String aPath) {
        checkArgument(!isNullOrEmpty(aPath), "aPath cannot be null or empty");
        this.path = aPath;
    }

    /**
     * Reads the file line after line and returns the whole file
     * content as a String.
     *
     * @return String representation of the text which was read
     * @throws IOException if there was an error opening/accessing/reading the file
     */
    public final String readFile() throws IOException {
        String readText = "";

        BufferedReader br = createBufferedReader();

        String strLine = "";
        while ((strLine = br.readLine()) != null)
            readText += strLine + "\n";

        br.close();
        return readText;
    }

    /**
     * Reads line after line to the supplied Collection of Strings 
     * @param collection A collection where the lines read are going to be appended to. 
     * @throws IOException if there was an error opening/accessing/reading the file
     */
	public final void readLines(final Collection<String> collection) throws IOException {
		Validator.checkNotNull(collection,
				"Collection supplied must not be null");
		BufferedReader br = null;
		try {
			br = createBufferedReader();
			String strLine = "";
			while ((strLine = br.readLine()) != null) {
				collection.add(strLine);
			}
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}
    
    /**
     * Reads the file line after line to a List of Strings. The file is always closed.  
     * @return the List of Strings read from the file
     * @throws IOException if there was an error opening/accessing/reading the file
     */
    public final List<String> readLines() throws IOException {
        List<String> linesRead = new LinkedList<String>();
        readLines(linesRead);
        return linesRead;
    }
    
    /**
     * Creates a BufferedReader from the path supplied.
     * @return A BufferedReader for the path specified
     * @throws IOException if file is not found
     */
    private BufferedReader createBufferedReader() throws IOException {
        java.io.FileReader fReader = new java.io.FileReader(this.path);
        BufferedReader br = new BufferedReader(fReader);
        return br;
    }
    

}
