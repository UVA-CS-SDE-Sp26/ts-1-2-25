import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopSecretTest {

    @Test
    void printFileList() {
        TopSecret testFileList = new TopSecret();
        assertEquals("", testFileList, "");
    }

    @Test
    void printFile() {
        TopSecret testPrintFile = new TopSecret();
        assertEquals("", testPrintFile, "");
    }
}