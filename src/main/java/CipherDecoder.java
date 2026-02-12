import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CipherDecoder {

    public String decipher(String input) {
        // if there is no input treat it as an empty string to avoid crashes
        if (input == null) {
            input = "";
        }

        String realLine;
        String cipherLine;

        // first: read the two lines from the key file for errors
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ciphers/key.txt"));

            realLine = reader.readLine();   // line 1: real characters
            cipherLine = reader.readLine(); // line 2: cipher characters

            reader.close();
        } catch (IOException e) {
            return "ERROR: Invalid key";
        }

        // next: key validation
        if (realLine == null || cipherLine == null) {
            return "ERROR: Invalid key";
        }
        if (realLine.length() != cipherLine.length()) {
            return "ERROR: Invalid key";
        }

        // after all passed, begin the deciphering
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            int index = cipherLine.indexOf(ch);

            if (index == -1) {
                // if the character is not in key we can just leave it alone
                result = result + ch;
            } else {
                // use position mapping to replace
                result = result + realLine.charAt(index);
            }
        }

        return result;
    }
}