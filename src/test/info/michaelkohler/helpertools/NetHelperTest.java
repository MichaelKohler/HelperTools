/* ============== HelperTools ==============
 * Initial developer: Lukas Diener (@LukasSkywalker)
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import info.michaelkohler.helpertools.io.NetHelper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class NetHelperTest {

    /** Can we compare the file size on the go instead of hardcoding it here? **/
    private final int FILE_SIZE = 6748;
    private final int CHUNK_SIZE = 4096;

    @Test
    public final void downloadFileTest() throws MalformedURLException {
        NetHelper.downloadFile(new URL("https://www.google.ch/images/srpr/logo3w.png"),
                "logo3w.png");
        File target = new File("logo3w.png");
        assertTrue(target.exists());
        assertEquals(target.length(), FILE_SIZE);
        target.delete();
    }

    @Test
    public final void downloadFile2Test() throws MalformedURLException {
        NetHelper.downloadFile("https://www.google.ch/images/srpr/logo3w.png",
               "logo3w2.png");
        File target = new File("logo3w2.png");
        assertTrue(target.exists());
        assertEquals(target.length(), FILE_SIZE);
        target.delete();
    }

    @Test
    public final void getInputStreamTest() throws IOException, InstantiationException {
        InputStream is = NetHelper.getUrlInputStream(
                new URL("https://www.google.ch/images/srpr/logo3w.png"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] byteChunk = new byte[CHUNK_SIZE];
        int n;
        while ((n = is.read(byteChunk)) > 0) {
            baos.write(byteChunk, 0, n);
        }
        assertEquals(baos.size(), FILE_SIZE);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNullGetUrilInput() throws IOException, InstantiationException {
        NetHelper.getUrlInputStream(null);
    }
}
