import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Parser {
    /**
     * Parse .txt file and puts all words to the list.
     *
     * @param fileName is a name .txt file
     * @return list words from a text document
     * @throws IOException
     */
    public List<String> parseFile(final String fileName) throws IOException {
        final List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            final Scanner scan = new Scanner(br);
            while (scan.hasNextLine()) {
                words.add(scan.nextLine());
            }
        }
        return words;
    }

    /**
     *Finds concatenation words from the list.
     *
     * @param firstWords is a list all words
     * @return list concatenation words
     */
    public List<String> findConcatenations(final List<String> firstWords) {
        final List<String> concatenatedWords = new ArrayList<>();
        final Set<String> secondWords = new HashSet<>();
        Collections.sort(firstWords, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        firstWords.forEach(word -> {
            if (checkConcatenated(word, secondWords)) {
                concatenatedWords.add(word);
            }
            secondWords.add(word);
        });
        return concatenatedWords;
    }

    private boolean checkConcatenated(final String word, final Set<String> secondWord) {
        final boolean[] isConcat = new boolean[word.length() + 1];
        isConcat[0] = true;
        for (int i = 1; word.length() >= i; i++) {
            for (int j = 0; j < i; j++) {
                if (!isConcat[j]) continue;
                if (secondWord.contains(word.substring(j, i))) {
                    isConcat[i] = true;
                }
            }
        }
        return isConcat[word.length()];
    }
}