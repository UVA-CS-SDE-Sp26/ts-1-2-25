import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CipherDecoderTest {

    @Test
    void basicDecipherSingleCharacter() {
        CipherDecoder decoder = new CipherDecoder();

        String result = decoder.decipher("b");

        assertEquals("a", result);
    }

    @Test
    void unmappedCharacterStaysSame() {
        CipherDecoder decoder = new CipherDecoder();

        String result = decoder.decipher("!");

        assertEquals("!", result);
    }

    @Test
    void decipherNewKeyUsesProvidedPath() {
        CipherDecoder decoder = new CipherDecoder();

        String result = decoder.decipherNewKey("b", "ciphers/key.txt");

        assertEquals("a", result);
    }
}
