import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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