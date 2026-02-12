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

    //Test 0, 1, and 2 parameters
    @Test
    void main() {
    }


    //Test with an integer, a string that is partly an integer, and a string with no integers
    @Test
    void isInteger() {
    }
}