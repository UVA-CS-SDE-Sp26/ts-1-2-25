import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CipherDecoder {

    // Making sure to match current ProgramControl: default key
    public String decipherDefaultKey(String input) {
        return decipherWithKeyFile(input, "ciphers/key.txt");
    }

    // Making sure to match current ProgramControl: default key
    public String decipherNewKey(String input, String keyPath) {
        return decipherWithKeyFile(input, keyPath);
    }

    // keeps your (program control) original method so any existing tests keep working
    public String decipher(String input) {
        return decipherDefaultKey(input);
    }

    // turned previous code into a helper method
    private String decipherWithKeyFile(String input, String keyPath) {
        // no input = make empty string to avoid crashes
        if (input == null) {
            input = "";
        }

        String realLine;
        String cipherLine;

        // first: read the two lines from the key file for errors
        try {
            BufferedReader reader = new BufferedReader(new FileReader(keyPath));

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
