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

import info.michaelkohler.helpertools.string.StringHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * The |FileHelper| is a static class which helps managing file paths.
 *
 * @author Lukas Diener
 * @version 0.0.1
 */
public final class FileHelper {
    /**
     * Empty private constructor, no instantiation needed.
     */
    private FileHelper() {

    }

    /**
     * Copies a file or a directory to another. Example:
     * <code>copy(new File(userDir, ".htaccess"), new File(httpdir, ".htaccess")</code>
     *
     * @param from Source file
     * @param to Destination file
     * @return whether the copy action was successful
     * @throws IOException Signals that the copy failed.
     */
    public static boolean copy(File from, File to) throws IOException {
        if (from.isDirectory()) {
            for (String name : Arrays.asList(from.list())) {
                if (!copy(from, to, name)) {
                    throw new IOException("Failed to copy " + name + " from "
                            + from + " to " + to);
                }
            }
        } else {
            FileInputStream is = new FileInputStream(from);
            FileOutputStream os = makeFile(to);

            // Transfer bytes from in to out
            byte[] buf = new byte[1024];
            int len;
            while ((len = is.read(buf)) > 0) {
                os.write(buf, 0, len);
            }
            is.close();
            os.close();
        }
        return true;
    }

    /**
     * Copies a file or a directory from one directory to another. Example:
     * <code>copy(new File("c:\\Users"), new File("c:\\Admin"), "Users.xml")</code>
     *
     * @param from Source file
     * @param to Destination file
     * @param what file or directory to be copied
     * @return whether the copy action was successful
     * @throws IOException Signals that the copy failed.
     */
    public static boolean copy(File from, File to, String what) throws IOException {
        File fromFile = new File(from, what);
        File toFile = new File(to, what);
        return copy(fromFile, toFile);
    }

    /**
     * Copies a file or a directory to another. Example:
     * <code>copy("C:\\windows.exe",
     * "C:\\Users\\CNorris\\Games\\pinball.exe")</code>
     *
     * @param from Source file
     * @param to Destination file
     * @return whether the copy action was successful
     * @throws IOException Signals that the copy failed.
     */
    public static boolean copy(String from, String to)
        throws IOException {
        return copy(new File(from), new File(to));
    }

    /**
     * Copies a file or a directory from one directory to another. Example:
     * <code>copy("c:\\Users", "c:\\Admin", "Users.xml")</code>
     *
     * @param from Source file
     * @param to Destination file
     * @param what file or directory to be copied
     * @return whether the copy action was successful
     * @throws IOException Signals that the copy failed.
     */
    public static boolean copy(String from, String to, String what) throws IOException {
        return copy(new File(from, what), new File(to, what));
    }

    /**
     * Gets the filename of the given path. Example:
     * <code>fileName("C:\\Users\\ChuckNorris\\passwords.txt")
     * </code> returns "passwords.txt"
     *
     * @param path a file path
     * @return the filename
     */
    public static String fileName(String path) {
        if (!StringHelper.isNullOrEmpty(path)) {
            path = path.substring(path.lastIndexOf(File.separatorChar) + 1);
        }
        return path;
    }

    /**
     * Lists files and directories with a name matching the regexp recursively.
     *
     * @param subdir starting directory
     * @param pattern Regular expression to match
     * @return List of names of the matching files/directories
     */
    public static List<String> find(File subdir, Pattern pattern) {
        List<String> resultSet = new ArrayList<String>();
        File[] contents = subdir.listFiles();

        for (File file : contents) {
            String path = file.getAbsolutePath();
            if (file.isDirectory()) {
                resultSet.addAll(find(file, pattern));
            }
            if (pattern.matcher(path).find()) {
                resultSet.add(path);
            } else {
                path = path.replace(File.separatorChar, '/');
                if (pattern.matcher(path).find()) {
                    resultSet.add(path);
                }
            }
        }
        return resultSet;
    }

    /**
     * Lists files and directories matching the RegExp recursively.
     *
     * @param subdir starting directory
     * @param pattern Regular expression to match
     * @return List of names of the matching files/directories
     */
    public static List<String> find(String subdir, Pattern pattern) {
        return find(new File(subdir), pattern);
    }

    /**
     * Lists files and directories matching the RegExp recursively.
     *
     * @param subdir starting directory
     * @param pattern Regular expression to match
     * @return List of names of the matching files/directories
     */
    public static List<String> find(String subdir, String pattern) {
        try {
            return find(subdir,
                    Pattern.compile(pattern));
        } catch (Exception e) {
            return new ArrayList<String>();
        }
    }

    /**
     * Checks if a folder is empty.
     *
     * @param directory folder to check
     * @return whether the folder is empty
     */
    public static boolean folderIsEmpty(File directory) {
        return (directory.isDirectory() && directory.list().length == 0);
    }

    /**
     * Checks if a folder is empty.
     *
     * @param directory folder to check
     * @return whether the folder is empty
     */
    public static boolean folderIsEmpty(String directory) {
        File dir = new File(directory);
        return folderIsEmpty(dir);
    }

    /**
     * Creates or opens a file for output. If subdirectories in the path do not
     * exist, they are created too.
     *
     * @param file File object of the file to create
     * @return FileOutputStream for the new file
     * @throws IOException Signals that the OutputStream could not be created
     */
    public static FileOutputStream makeFile(File file) throws IOException {
        return makeFile(file.getAbsolutePath());
    }

    /**
     * Creates or opens a file for output. If sub-directories in the path do not
     * exist, they are created too.
     *
     * @param path Path of the file to create
     * @return FileOutputStream for the new file
     * @throws IOException Signals that the OutputStream could not be created
     */
    public static FileOutputStream makeFile(String path)
        throws IOException {
        int sep = path.lastIndexOf(File.separator);
        String folder = path.substring(0, sep);
        String file = path.substring(sep + 1);
        return makeFile(folder, file, false);
    }

    /**
     * Creates or opens a file for output. If sub-directories in the path do not
     * exist, they are created too.
     *
     * @param path array of folders representing the path of the file to create
     * @return FileOutputStream for the new file
     * @throws IOException Signals that the OutputStream could not be created
     */
    public static FileOutputStream makeFile(String... path)
        throws IOException {
        if (path.length < 1) return null;
        else if (path.length < 2) return makeFile(path[0]);
        else if (path.length < 3) return makeFile(path[0], path[1]);
        else return makeFile(StringHelper.join(path, File.separator));
    }

    /**
     * Creates or opens a file for output. If sub-directories in the path do not
     * exist, they are created too. If the file exists, it is overwritten,
     * unless <code>append</code> is <b>true</b>. <code>append</code> determines
     * whether to open in <i>append</i> mode.
     *
     * @param dirname path to the file
     * @param filename name of the file to create
     * @param append whether to append or overwrite the file if it exists
     * @return FileOutputStream for the new file
     * @throws IOException Signals that the OutputStream could not be created
     */
    public static FileOutputStream makeFile(String dirname,
            String filename, boolean append) throws IOException {
        if (folderIsEmpty(new File(dirname))) {
            return new FileOutputStream(new File(filename), append);
        } else {
            File dir = new File(dirname);
            createFolders(dir);
            return new FileOutputStream(new File(dirname, filename), append);
        }
    }

    public static void createFolders(File path) {
        if (!path.exists()) {
            path.mkdirs();
        }
    }

    /**
     * Gets the path name of the given path. Example:
     * <code>fileName("C:\\Users\\ChuckNorris\\passwords.txt")
     * </code> returns "C:\Users\ChuckNorris"
     *
     * @param path a file path
     * @return the path name
     */
    public static String pathName(String path) {
        if (!StringHelper.isNullOrEmpty(path)) {
            if (path.lastIndexOf(File.separatorChar) > -1) {
                path = path.substring(0, path.lastIndexOf(File.separatorChar));
            } else {
                return "";
            }
        }
        return path;
    }

    /**
     * Splits a path and a filename in its parts. Example:
     * <code>splitPath("C:\\Users\\John\\Image.jpg")
     * returns ["C:", "Users", "John", "Image.jpg"]</code>
     *
     * @param path input path
     * @return String array consisting of path and filename
     */
    public static String[] splitPath(String path) {
        return path.split(Pattern.quote(File.separator));
    }

    /**
     * Returns a new file after adding the specified file/folder to the end
     * of the path. Example:
     * <code>append("C:\Users\John", "Image.jpg");
     * returns File["C:\Users\John\Image.jpg"]</code>
     *
     * @param baseFile input path
     * @param name name of file/folder to add
     * @return the new object
     */
    public static File append(String baseFile, String name) {
        StringBuilder sb = new StringBuilder(baseFile);
        if (!baseFile.endsWith(File.pathSeparator)) sb.append(File.separatorChar);
        sb.append(name);
        return new File(sb.toString());
    }

    /**
     * Returns a new file after adding the specified file/folder to the end
     * of the path. Example:
     * <code>append(new File("C:\Users\John"), "Image.jpg");
     * returns File["C:\Users\John\Image.jpg"]</code>
     *
     * @param baseFile input path
     * @param name name of file/folder to add
     * @return the new object
     */
    public static File append(File baseFile, String name) {
        return append(baseFile.getAbsolutePath(), name);
    }

    /**
     * Returns the current directory as file object.
     *
     * @return the file object of the current dir
     */
    public static File currentDir() {
        return new File(System.getProperty("user.dir"));
    }
}