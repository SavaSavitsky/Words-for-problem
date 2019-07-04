import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    Parser parser = new Parser();

    @Test
    void parseFile() throws IOException {
        List<String> words = parser.parseFile("words.txt");
        assertNotNull(words);
        assertEquals(words, parser.parseFile("words.txt"));
    }

    @Test
    void findConcatenations() throws IOException {
        List<String> words = parser.parseFile("words.txt");
        List<String> concatenationsWords = parser.findConcatenations(words);
        assertNotNull(concatenationsWords);
        assertNotEquals(words, concatenationsWords);
    }
}