import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopSecretTest {

    //Testing the function to print a list of files
    @Test
    void printFileList() {
        TopSecret testFileList = new TopSecret();
        assertEquals("", testFileList, "");
    }

    //Testing the function to print a specific file
    @Test
    void printFile() {
        TopSecret testPrintFile = new TopSecret();
        assertEquals("", testPrintFile, "");
    }

    @Test
    void main() {
    }


    @Test
    void isInteger() {
    }
}