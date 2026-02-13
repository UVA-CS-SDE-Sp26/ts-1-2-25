import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopSecretTest {

    //All the real testing is below but for code coverage I included this one
    @Test
    void mainMethodNoError() {
        String[] args = {};
        assertDoesNotThrow( () ->TopSecret.main(args));
    }

    //Test 0, 1, and 2 parameters, and with invalid inputs - the easiest way seemed to be with streams
    @Test
    void mainTestNoArgs() {
        String[] args = {};
        assertEquals(0, TopSecret.run(args), "This should run fine, so it should return 0");
    }

    @Test
    void mainTestOneArgValid() {
        String[] args = {"1"};
        assertEquals(0, TopSecret.run(args), "This should run fine, so it should return 0");
    }

    @Test
    void mainTestOneArgInvalid() {
        String[] args = {"a"};
        assertEquals(-1, TopSecret.run(args), "This should not run fine, so it should return -1");
    }
    @Test
    void mainTestTwoArgValid() {
        String[] args = {"1", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890\n" +
                "bcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890a"};
        assertEquals(0, TopSecret.run(args), "This should run fine, so it should return 0");
    }

    @Test
    void mainTestTwoArgInvalid() {
        String[] args = {"a", "a"};
        assertEquals(-1, TopSecret.run(args), "This should not run fine, so it should return -1");
    }

    @Test
    void mainTestThreeArg() {
        String[] args = {"a", "a", "a"};
        assertEquals(-1, TopSecret.run(args), "This should not run fine, so it should return -1");
    }

    //Test constructor
    @Test
    void constructorTestWithTwoParams(){
        String[] args = new String[2];
        args[0] = "1";
        args[1] = "aaaa";
        TopSecret constructorTest = new TopSecret(args);
        assertEquals(1, constructorTest.getFileNumber(), "getFileNumber should return what was in args[0]");
        assertEquals("aaaa", constructorTest.getCipher(), "getCipher should return what was in args[1]");
    }
    @Test
    void constructorTestWithOneParam(){
        String[] args = new String[1];
        args[0] = "1";
        TopSecret constructorTest = new TopSecret(args);
        assertEquals(1, constructorTest.getFileNumber(), "getFileNumber should return what was in args[0]");
        assertEquals(null, constructorTest.getCipher(), "getCipher should return null as the value wasn't set");
    }
    @Test
    void constructorTestWithNoParams(){
        String[] args = new String[0];
        TopSecret constructorTest = new TopSecret(args);
        assertEquals(0, constructorTest.getFileNumber(), "getFileNumber should return 0 as the value wasn't set");
        assertEquals(null, constructorTest.getCipher(), "getCipher should return NULL as the value wasn't set");
    }
    //Test with an integer, a string that is partly an integer, and a string with no integers
    @Test
    void isInteger_validNumber() {
        assertEquals(5, TopSecret.isInteger("5"), "Becuase 5 is an integer, the method should return it");
    }
    @Test
    void isInteger_invalidNumber() {
        assertEquals(-1, TopSecret.isInteger("abc"), "Becuase abc isn't an integer, the method should return -1");
    }
    @Test
    void isInteger_invalidNotNumber() {
        assertEquals(-1, TopSecret.isInteger("abc123"), "Becuase abc123 isn't an integer, the method should return -1");
    }
}