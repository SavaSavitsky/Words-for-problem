import java.io.IOException;
import java.util.List;

/**
 * Concatenated Words
 * Author: Alexandr Savitsky.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        List<String> words = parser.parseFile("words.txt");
        List<String> allСoncatenations = parser.findConcatenations(words);

        System.out.println("The longest concatenated word: " + allСoncatenations.get(allСoncatenations.size() - 1));
        System.out.println("The 2nd longest concatenated word: " + allСoncatenations.get(allСoncatenations.size() - 3));
        System.out.println("The total count of all the concatenated words in the file: " + allСoncatenations.size());
    }
}
