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
package info.michaelkohler.helpertools.io;

import java.io.InputStream;

/**
 * |NetHelper| is a helper class for various internet-
 * related actions, such as downloading files and sending
 * e-mails.
 *
 * @author Lukas Diener
 * @version 0.0.1
 */
public final class NetHelper {

    /**
     * Empty Constructor.
     */
    private NetHelper() {
    }

    /**
     * Downloads a file from a specified URL.
     *
     * @param url URL that points to a resource
     * @param filename the name of the file to store the contents
     * @return error message or empty string for success
     */
    public static String downloadFile(java.net.URL url, String filename) {
        try {
            FileWriter fw = new FileWriter(filename, false);
            fw.writeFile(getUrlInputStream(url));
        } catch (Exception e) {
            return "error: " + e;
        }
        return "";
    }

    /**
     * gets an input stream for a given url.
     * @param url the url to download from
     * @return the input stream
     * @throws java.io.IOException Signals that the download failed.
     * @throws java.lang.InstantiationException Signals that something failed.
     */
    public static InputStream getUrlInputStream(java.net.URL url)
        throws java.io.IOException, java.lang.InstantiationException {
        InputStream input = url.openStream();
        if (input == null) {
            throw new java.lang.InstantiationException("Url " + url
                    + " does not provide data.");
        }
        return input;
    }

    /**
     * Downloads a file from a specified URL.
     *
     * @param url URL string that points to a resource
     * @param filename the name of the file to store the contents
     * @return error message; an empty string if none
     */
    public static String downloadFile(String url, String filename) {
        try {
            downloadFile(new java.net.URL(url), filename);
        } catch (Exception e) {
            return "error: " + e;
        }
        return "";
    }
}