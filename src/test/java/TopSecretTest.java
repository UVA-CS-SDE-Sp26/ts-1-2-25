import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TopSecretTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    //Test 0, 1, and 2 parameters, and with invalid inputs - the easiest way seemed to be with streams
    @Test
    void mainTestNoArgs() {
        String[] args = {};

        assertEquals("", outputStreamCaptor.toString().trim());

    }

    @Test
    void mainTestOneArgValid() {
        String[] args = {"1"};
        TopSecret.main(args);
        assertEquals("test sample text", outputStreamCaptor.toString().trim());
    }

    @Test
    void mainTestOneArgInvalid() {
        String[] args = {"a"};

        PrintStream originalOut = System.out;

        ByteArrayOutputStream output1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output1));
        TopSecret.main(args);

        System.setOut(originalOut);
        assertTrue(output1.toString().contains("must a number"));
    }
    @Test
    void mainTestTwoArgValid() {
        String[] args = {"1", "cdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890ab"};
        TopSecret.main(args);
        assertEquals("test sample text", outputStreamCaptor.toString().trim());
    }

    @Test
    void mainTestTwoArgInvalid() {
        String[] args = {"a", "aaaa"};
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output2));
        TopSecret.main(args);
        System.setOut(originalOut);
        assertTrue(output2.toString().contains("must a number"));
    }

    //Test constructor
    @Test
    void constructorTest(){
        String[] args = new String[2];
        args[0] = "1";
        args[1] = "aaaa";
        TopSecret constructorTest = new TopSecret(args);
        assertEquals(1, constructorTest.getFileNumber(), "getFileNumber should return what was in args[0]");
        assertEquals("aaaa", constructorTest.getCipher(), "getCipher should return what was in args[1]");
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