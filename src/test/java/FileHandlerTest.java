import  org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import java.util.ArrayList;

// These tests assume there is a 'test.txt' file in /data folder

class FileHandlerTest {

    FileHandler fileHandler = new FileHandler();

    @Test
    void listFiles() {
        ArrayList<String> files = fileHandler.listFiles();
        // Should not be null
        assertNotNull(files);
        // assume test.txt folder in data
        assertTrue(files.size() >= 0);
    }

    @Test
    void getFileContent_byName() {
        // assume /data exists
        ArrayList<String> files = fileHandler.listFiles();
        if(!files.isEmpty()) {
            String fileName =  files.get(0);
            String content = fileHandler.getFileContent(fileName);
            assertNotNull(content);
        } else{
            fail("Data folder is empty so cannot test.");
        }
    }

    @Test
    void getFileContent_byInvalidName() {
        String content = fileHandler.getFileContent("doesNotExist.txt");
        assertNull(content);
    }

    @Test
    void getFileContent_byIndex() {
        // assume /data exists
        ArrayList<String> files = fileHandler.listFiles();
        if (!files.isEmpty()) {
            String content = fileHandler.getFileContent(1);
            assertNotNull(content);
            assertFalse(content.isEmpty());
        } else {
            fail("Data folder is empty, cannot get file content by the index.");
        }
    }

    @Test
    void getFileContent_invalidIndex() {
        String content = fileHandler.getFileContent(999);
        assertNull(content);
    }
}