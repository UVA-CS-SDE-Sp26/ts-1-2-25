import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class ProgramControlTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testListFiles(){
        ArrayList<String> x = ProgramControl.listFiles();

        //Shouldn't be null
        assertNotNull(x);

        //make sure it includes test.txt
        assertTrue(x.contains("test.txt"));
    }

    @Test
    void testDisplayFiles(){
        //make sure displayFiles is getting right file
        String[] args = {"1"};
        ProgramControl.displayFiles(args);
        //using the cipher, the encoded text "test sample text" is "uftu tbnqmf ufyu"
        assertEquals("Lhmtsdr hmsn ghr C0kk0r L0udqhbjr cdats.", outputStreamCaptor.toString().trim());
        //The sample text was something that made sense before but my groupmates changed the content of test.txt
        //to test their stuff so that's why it looks like this now
    }


    @Test
    void testDisplayFiles2(){
        //make sure displayFiles is getting right file
        String[] args = {"2"};
        ProgramControl.displayFiles(args);
        //using the cipher, the encoded text "test sample text" is "uftu3"
        assertEquals("test2", outputStreamCaptor.toString().trim());
    }

    @Test
    void testRun(){
        String[] args = {"1"};
        ProgramControl.run(args);
        //using the cipher, the encoded text "test sample text" is "uftu tbnqmf ufyu"
        assertEquals("Lhmtsdr hmsn ghr C0kk0r L0udqhbjr cdats.", outputStreamCaptor.toString().trim());
        //The sample text was something that made sense before but my groupmates changed the content of test.txt
        //to test their stuff so that's why it looks like this now
    }

    @Test
    void testRun2(){
        String[] args = {"2"};
        ProgramControl.run(args);
        //using the cipher, the encoded text "test sample text" is "uftu3"
        assertEquals("test2", outputStreamCaptor.toString().trim());
    }

    @Test
    void testRun3(){
        //text when no args
        String[] noArgs = new String[0];
        ProgramControl.run(noArgs);
        assertEquals( "1 test.txt" + System.lineSeparator() + "2 test2.txt", outputStreamCaptor.toString().trim());
    }
}
