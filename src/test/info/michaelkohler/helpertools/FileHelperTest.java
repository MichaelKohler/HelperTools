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
    private static String relativePath;
    private static String fileName = "myFile.txt";
    private static String dirName = "myDir";
    
    private static File currentDir;
    private static File testFile;
    private static File subFolder;
    private static File testFile2;
    private static File targetFile;

    public FileHelperTest() {
    }

    @Before
    public final void setUp() throws IOException {
        relativePath = StringHelper.join(new String[]{dirName, fileName}, separator);
    }
    
    public void createStructure() throws IOException{
        currentDir = FileHelper.append(FileHelper.currentDir(), "temp");
        currentDir.mkdir();
        testFile = FileHelper.append(currentDir, "myFile.txt");
        testFile.createNewFile();
        subFolder = FileHelper.append(currentDir, "myFolder");
        subFolder.mkdir();
        testFile2 = FileHelper.append(subFolder, "bla.txt");
        testFile2.createNewFile();
        targetFile = FileHelper.append(subFolder, "myFile.txt");
    }
    
    public void clearStructure(File...additional) {
        testFile.delete();
        for(File file : additional) file.delete();
        testFile2.delete();
        if(targetFile.exists()) targetFile.delete();
        subFolder.delete();
    }
    
    @Test
    public final void testCopyFileFile() throws IOException {  
        createStructure();
        FileHelper.copy(testFile, targetFile);
        assertTrue(targetFile.exists());
        clearStructure();
    }
    
    @Test
    public final void testCopyFileFileStr() throws IOException {
        createStructure();
        FileHelper.copy(currentDir, subFolder, "myFile.txt");
        assertTrue(targetFile.exists());
        clearStructure();
    }
    
    @Test
    public final void testCopyStrStr() throws IOException {
        createStructure();
        String source = testFile.getAbsolutePath();
        String target = targetFile.getAbsolutePath();
        FileHelper.copy(source,
                target);
        assertTrue(targetFile.exists());
        clearStructure();
    }

    @Test
    public final void testCopyStrStrStr() throws IOException {
        createStructure();
        FileHelper.copy(currentDir.getAbsolutePath(),
                subFolder.getAbsolutePath(),
                "myFile.txt");
        assertTrue(targetFile.exists());
        clearStructure();
    }

    @Test
    public final void testFileName() {
        assertEquals(FileHelper.fileName(relativePath), fileName);
        assertEquals(FileHelper.fileName(fileName), fileName);
        assertEquals(FileHelper.fileName(dirName), dirName);
    }
    
    @Test
    public final void testFind() throws IOException {
        createStructure();
        ArrayList<String> expectedResult = new ArrayList<String>();
        List<String> actualResult = FileHelper.find(currentDir, Pattern.compile("blergh"));
        assertEquals(expectedResult, actualResult);
        actualResult = FileHelper.find(currentDir.getAbsolutePath(), Pattern.compile("blergh"));
        assertEquals(expectedResult, actualResult);
        actualResult = FileHelper.find(currentDir.getAbsolutePath(), "blergh");
        assertEquals(expectedResult, actualResult);
        
        expectedResult.add(testFile.getAbsolutePath());
        actualResult = FileHelper.find(currentDir, Pattern.compile("myFile"));
        assertEquals(expectedResult, actualResult);
        actualResult = FileHelper.find(currentDir.getAbsolutePath(), Pattern.compile("myFile"));
        assertEquals(expectedResult, actualResult);
        actualResult = FileHelper.find(currentDir.getAbsolutePath(), "myFile");
        assertEquals(expectedResult, actualResult);
        
        expectedResult.add(testFile2.getAbsolutePath());
        actualResult = FileHelper.find(currentDir, Pattern.compile(".+\\.txt"));
        assertEquals(expectedResult, actualResult);
        actualResult = FileHelper.find(currentDir.getAbsolutePath(), Pattern.compile(".+\\.txt"));
        assertEquals(expectedResult, actualResult);
        actualResult = FileHelper.find(currentDir.getAbsolutePath(), ".+\\.txt");
        assertEquals(expectedResult, actualResult);
        clearStructure();
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
        createStructure();
        FileOutputStream fos = FileHelper.makeFile(targetFile);
        fos.write(12);
        fos.close();
        assertTrue(targetFile.exists());
        clearStructure();
    }
    
    @Test
    public final void testMakeFileFile() throws IOException {
        createStructure();
        FileOutputStream fos = FileHelper.makeFile(targetFile);
        fos.write(12);
        fos.close();
        assertTrue(targetFile.exists());
        clearStructure();
    }
    
    @Test
    public final void testMakeFileStrArr() throws IOException {
        createStructure();
        String[] path = targetFile.getAbsolutePath().split(Pattern.quote(File.separator));
        FileOutputStream fos = FileHelper.makeFile(path);
        fos.write(12);
        fos.close();
        assertTrue(targetFile.exists());
        clearStructure();
    }
    
    @Test
    public final void testMakeFileStrStrBool() throws IOException {
        createStructure();
        FileOutputStream fos = FileHelper.makeFile(subFolder.getAbsolutePath(), "myFile.txt", false);
        fos.write(12);
        fos.close();
        assertTrue(targetFile.exists());
        targetFile.delete();
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
        String[] actualResult = FileHelper.splitPath("C:\\Users\\John\\Image.jpg");
        for(int i=0; i<expectedResult.length; i++) {
            assertEquals(expectedResult[i], actualResult[i]);
        }
    }
    
    @Test
    public final void testAppend() {
        String path = "C:\\Users\\CNorris";
        String path2 = "C:\\Users\\CNorris\\";
        String file = "Image.jpg";
        File result = FileHelper.append(path, file);
        assertEquals("C:\\Users\\CNorris\\Image.jpg", result.getAbsolutePath());
        
        File result2 = FileHelper.append(path2, file);
        assertEquals("C:\\Users\\CNorris\\Image.jpg", result2.getAbsolutePath());
    }

    @After
    public void tearDown() {
        //nothing to do here
    }
}
