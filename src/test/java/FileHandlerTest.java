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
        assertTrue(files.contains("test.txt"));
    }

    @Test
    void getFileContent_byName() {
        // Make sure test.txt exists in data folder
        String content = fileHandler.getFileContent("test.txt");
        assertNotNull(content);
        assertFalse(content.isEmpty());
    }

    @Test
    void getFileContent_byInvalidName() {
        String content = fileHandler.getFileContent("doesNotExist.txt");
        assertNull(content);
    }

    @Test
    void getFileContent_byIndex() {
        ArrayList<String> files = fileHandler.listFiles();
        if (!files.isEmpty()) {
            String content = fileHandler.getFileContent(1);
            assertNotNull(content);
        }
    }

    @Test
    void getFileContent_invalidIndex() {
        String content = fileHandler.getFileContent(999);
        assertNull(content);
    }
}