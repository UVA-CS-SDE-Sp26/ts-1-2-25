import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopSecretTest {

    //Testing the function to print a list of files
    @Test
    void printFileList() {
        String[] args = new String[2];
        args[0] = "";
        args[1] = "";
        TopSecret testFileList = new TopSecret(args);
        assertEquals("", testFileList, "");
    }

    //Testing the function to print a specific file (file 1)
    @Test
    void printFile() {
        String[] args = new String[2];
        args[0] = "1";
        args[1] = "";
        TopSecret testPrintFile = new TopSecret(args);
        //assertEquals("", testPrintFile.printFile(args), "");
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