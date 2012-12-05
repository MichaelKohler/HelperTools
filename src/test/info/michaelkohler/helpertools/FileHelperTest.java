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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import info.michaelkohler.helpertools.io.FileHelper;
import info.michaelkohler.helpertools.string.StringHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class FileHelperTest  {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    private static String separator = new String(new char[]{File.separatorChar});
    private static String fileName = "myFile.txt";
    private static String dirName = "myDir";
    private static String relativePath = StringHelper.join(new String[]{dirName, fileName}, separator);

    private static File tempDir;
    private static File testFile;
    private static File subFolder;
    private static File testFile2;
    private static File targetFile;

    /**
     * This creates a folder structure to test against. Looks like
     * -temp
     * --myFile.txt
     * --myFolder
     * ---bla.txt
     * ---(myFile.txt)
     * The myFile.txt in myFolder is only a reference and no existing
     * file. Can be used to test copy/create operations.
     */
    @Before
    public final void setUp() throws IOException {
		tempDir = FileHelper.append(
				new File(System.getProperty("java.io.tmpdir")), "temp");
        tempDir.mkdir();
        testFile = FileHelper.append(tempDir, "myFile.txt");
        testFile.createNewFile();
        subFolder = FileHelper.append(tempDir, "myFolder");
        subFolder.mkdir();
        testFile2 = FileHelper.append(subFolder, "bla.txt");
        testFile2.createNewFile();
        targetFile = FileHelper.append(subFolder, "myFile.txt");
    }

    /**
     * This methode deletes all files and folders mentioned in {@link #setUp()}.
     */
    @After
    public void tearDown() {
        testFile.delete();
        testFile2.delete();
        if(targetFile.exists()) targetFile.delete();
        subFolder.delete();
        tempDir.delete();
    }

    @Test
    public final void testCopyFileFile() throws IOException {
        FileHelper.copy(testFile, targetFile);
        assertTrue(targetFile.exists());
    }

    @Test
    public final void testCopyFileFileStr() throws IOException {
        FileHelper.copy(tempDir, subFolder, "myFile.txt");
        assertTrue(targetFile.exists());
    }

    @Test
    public final void testCopyStrStr() throws IOException {
        String source = testFile.getAbsolutePath();
        String target = targetFile.getAbsolutePath();
        FileHelper.copy(source,
                target);
        assertTrue(targetFile.exists());
    }

    @Test
    public final void testCopyStrStrStr() throws IOException {
        FileHelper.copy(tempDir.getAbsolutePath(),
                subFolder.getAbsolutePath(),
                "myFile.txt");
        assertTrue(targetFile.exists());
    }

    @Test
    public final void testFileName() {
        assertEquals(FileHelper.fileName(relativePath), fileName);
        assertEquals(FileHelper.fileName(fileName), fileName);
        assertEquals(FileHelper.fileName(dirName), dirName);
    }

    @Test
	public final void findNoResults() throws IOException {
		findPatternInDirectory(tempDir, "blergh", Collections.<String>emptyList());
	}


	@Test
	public final void findSingleResult() throws IOException {
		findPatternInDirectory(tempDir, "myFile",
				Collections.singletonList(testFile.getAbsolutePath()));
	}

	@Test
	public final void findMoreResults() throws IOException {
		List<String> expectedResult = Arrays.asList(testFile.getAbsolutePath(),
				testFile2.getAbsolutePath());
		findPatternInDirectory(tempDir, ".+\\.txt", expectedResult);
    }


	@Test
    public final void testFolderIsEmpty() throws IOException {
        assertTrue(FileHelper.folderIsEmpty(folder.getRoot()));
        assertTrue(FileHelper.folderIsEmpty(folder.getRoot().getAbsolutePath()));
        folder.newFile("bla");
        assertFalse(FileHelper.folderIsEmpty(folder.getRoot()));
        assertFalse(FileHelper.folderIsEmpty(folder.getRoot().getAbsolutePath()));
    }

    @Test
    public final void testMakeFileStr() throws IOException {
        FileOutputStream fos = FileHelper.makeFile(targetFile);
        fos.write(12);
        fos.close();
        assertTrue(targetFile.exists());
    }

    @Test
    public final void testMakeFileFile() throws IOException {
        FileOutputStream fos = FileHelper.makeFile(targetFile);
        fos.write(12);
        fos.close();
        assertTrue(targetFile.exists());
    }

    @Test
    public final void testMakeFileStrArr() throws IOException {
        String[] path = targetFile.getAbsolutePath().split(Pattern.quote(File.separator));
        FileOutputStream fos = FileHelper.makeFile(path);
        fos.write(12);
        fos.close();
        assertTrue(targetFile.exists());
    }

    @Test
    public final void testMakeFileStrStrBool() throws IOException {
        FileOutputStream fos = FileHelper.makeFile(subFolder.getAbsolutePath(), "myFile.txt", false);
        fos.write(12);
        fos.close();
        assertTrue(targetFile.exists());
    }

    @Test
    public final void testPathName() {
        assertEquals(FileHelper.pathName(relativePath), dirName);
        assertEquals(FileHelper.pathName(fileName), "");
        assertEquals(FileHelper.pathName(dirName), "");
    }

    @Test
    public final void testSplitPath() {
        String[] expectedResult = new String[]{"C:","Users","John","Image.jpg"};
        String sep = File.separator;
        String[] actualResult = FileHelper.splitPath("C:"+sep+"Users"+sep+"John"+sep+"Image.jpg");
        for(int i=0; i<expectedResult.length; i++) {
            assertEquals(expectedResult[i], actualResult[i]);
        }
    }

    @Test
    public final void testAppend() {
        String sep = File.separator;
        String path = "some"+sep+"fake"+sep+"path";
        String path2 = "some"+sep+"other"+sep+"path";
        String file = "Image.jpg";

        File result = FileHelper.append(path, file);
        assertEquals(path + sep + file, result.getPath());

        File result2 = FileHelper.append(path2, file);
        assertEquals(path2 + sep + file, result2.getPath());
    }

	// probably this test should write to System.getProperty("java.io.tempdir")
	// to avoid messing up source
	// timeout for infinite loop detection
	@Test(timeout = 500000000)
    public void testMakeFileNullCausesStackOverflow() throws IOException {
        // Regression test to prevent MakeFile from going into an infinite loop
        // if the size of its inputs are two
    	try {
    		FileHelper.makeFile("a", "b");
    	}
    	finally {
    		File f = new File("a/b");
			if (f.exists()) {
				f.delete();
				f.getParentFile().delete();
			}
    	}

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCopyNullFromFile() throws IOException {
        FileHelper.copy(null, new File("something"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCopyNullToFile() throws IOException {
        FileHelper.copy(new File("something"), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCopyNullWhat() throws IOException {
        FileHelper.copy(new File("A"), new File("B"), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindNullFile() throws IOException {
        File f = null;
        FileHelper.find(f, Pattern.compile(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindNullPattern() throws IOException {
        File f = null;
        FileHelper.find(f, Pattern.compile(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindNullSubdir() throws IOException {
        String s = null;
        FileHelper.find(s, Pattern.compile(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFolderIsEmptyNullFile() throws IOException {
        File f = null;
        FileHelper.folderIsEmpty(f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFolderIsEmptyNullString() throws IOException {
        String s = null;
        FileHelper.folderIsEmpty(s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFolderIsEmptyNull() throws IOException {
        File f = null;
        FileHelper.folderIsEmpty(f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMakeFileNullArgs() throws IOException {
        String[] s = null;
        FileHelper.makeFile(s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMakeFileNullArg() throws IOException {
        String s = null;
        FileHelper.makeFile(s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMakeFileNullDir() throws IOException {
        FileHelper.makeFile(null, "file", false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMakeFileNullFile() throws IOException {
        FileHelper.makeFile("dir", null, false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendNullBase() throws IOException {
        String s = null;
        FileHelper.append(s, "name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendNullBaseFile() throws IOException {
        File f = null;
        FileHelper.append(f, "name");
    }

	private void findPatternInDirectory(File localtemp, final String pattern,
			List<String> expectedResult) {
		List<String> actualResult = FileHelper.find(localtemp,
				Pattern.compile(pattern));
		assertSortedEquals(expectedResult, actualResult);
		actualResult = FileHelper.find(localtemp.getAbsolutePath(),
				Pattern.compile(pattern));
		assertSortedEquals(expectedResult, actualResult);
		actualResult = FileHelper.find(localtemp.getAbsolutePath(), pattern);
		assertSortedEquals(expectedResult, actualResult);
	}

	private static <T extends Comparable<T>> void assertSortedEquals(
			List<T> expected, List<T> actual) {

		assertEquals(copyAndSort(expected), copyAndSort(actual));
	}

	private static <T extends Comparable<T>> List<T> copyAndSort(List<T> input) {
		List<T> copy = new ArrayList<T>(input);
		Collections.sort(copy);
		return copy;
	}
}
