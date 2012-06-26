/* ============== HelperTools ==============
 * Initial developer: Lukas Diener <lukas.diener@hotmail.com>
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

import info.michaelkohler.helpertools.io.FileHelper;
import info.michaelkohler.helpertools.string.StringHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.File;

public class FileHelperTest  {
    private static String separator = new String(new char[]{File.separatorChar});
    private static String relativePath;
    private static String fileName = "myFile.txt";
    private static String dirName = "myDir";

    public FileHelperTest() {
    }

    @Before
    public final void setUp() {
        relativePath = StringHelper.join(new String[]{dirName, fileName}, separator);
    }

    @Test
    public final void testFileName() {
        assertEquals(FileHelper.fileName(relativePath), fileName);
        assertEquals(FileHelper.fileName(fileName), fileName);
        assertEquals(FileHelper.fileName(dirName), dirName);
    }

    @Test
    public final void testPathName() {
        assertEquals(FileHelper.pathName(relativePath), dirName);
        assertEquals(FileHelper.pathName(fileName), "");
        assertEquals(FileHelper.pathName(dirName), "");
    }

    @After
    public void tearDown() {
        //nothing to do here
    }
}
