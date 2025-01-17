package FileSearch;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.*;

class FileSearchTest {
    
    private File rootTestDir;
    
    @BeforeEach
    public void setup() throws IOException {
        rootTestDir = Files.createTempDirectory("testDir").toFile();

        // Create files and subdirectories
        new File(rootTestDir, "file1.txt").createNewFile();
        new File(rootTestDir, "file2.txt").createNewFile();
        File subDir1 = new File(rootTestDir, "subDir1");
        subDir1.mkdir();
        new File(subDir1, "file3.txt").createNewFile();
        new File(subDir1, "file4.txt").createNewFile();
        File subDir2 = new File(rootTestDir, "subDir2");
        subDir2.mkdir();
        new File(subDir2, "file2.txt").createNewFile();
    }
    
    @AfterEach
    public void tearDown() {
        deleteDirectory(rootTestDir);
    }
    
    private void deleteDirectory(File directory) {
        File[] allContents = directory.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        directory.delete();
    }

    @Test
    public void testFileInRootDirectory() {
        assertTrue(FileSearch.searchFile(rootTestDir, "file1.txt"));
    }

    @Test
    public void testFileInSubdirectory() {
        assertTrue(FileSearch.searchFile(rootTestDir, "file4.txt"));
    }

    @Test
    public void testFileNotFound() {
        assertFalse(FileSearch.searchFile(rootTestDir, "nonExistentFile.txt"));
    }

    @Test
    public void testDirectoryDoesNotExist() {
        File nonExistentDir = new File(rootTestDir, "nonExistentDir");
        assertFalse(FileSearch.searchFile(nonExistentDir, "file1.txt"));
    }

    @Test
    public void testMultipleOccurrencesOfFile() {
        assertTrue(FileSearch.searchFile(rootTestDir, "file2.txt"));
    }

    @Test
    public void testCaseSensitivity() {
        // Assuming the method is modified to accept case sensitivity as an option
        assertFalse(FileSearch.searchFile(rootTestDir, "FILE1.txt")); // Case-sensitive check
    }
}
