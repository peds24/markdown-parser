import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParseTest {
    public void failingTest() {
        assertEquals(2, 1 + 1);
    }

    public void testFileTest() throws IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> toReturn = MarkdownParse.getLinks(content);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://something.com");
        expected.add("some-thing.html");

        assertEquals(expected, toReturn);
    }

    public void justParenthTest() throws IOException {
        Path fileName = Path.of("justParenth.md");
        String content = Files.readString(fileName);
        ArrayList<String> toReturn = MarkdownParse.getLinks(content);

        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected, toReturn);
    }

    public void emtpyFile() throws IOException {
        Path fileName = Path.of("justParenth.md");
        String content = Files.readString(fileName);
        ArrayList<String> toReturn = MarkdownParse.getLinks(content);

        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected, toReturn);
    }

    public void noParenth() throws IOException {
        Path fileName = Path.of("noParenth.md");
        String content = Files.readString(fileName);
        ArrayList<String> toReturn = MarkdownParse.getLinks(content);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://www.netflix.com/");
        assertEquals(expected, toReturn);
    }

    public void spaceBetween() throws IOException {
        Path fileName = Path.of("spaceBetween.md");
        String content = Files.readString(fileName);
        ArrayList<String> toReturn = MarkdownParse.getLinks(content);

        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected, toReturn);
    }
    // Lab 4 Tests
    // Snippet 1
    // [[another link](`google.com)]

    // Snippet 2
    // [[nested link](a.com),[a nested parenthesized url](a.com(())), [some escaped
    // \[ brackets \]](example.com)]

    // Snippet 3
    // [[this title text is really long and takes up more than
    // oneline](https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule)]
}
