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
    // Personal
    public void Snippet1Personal() throws IOException {
        Path fileName = Path.of("snippet1.md");
        String content = Files.readString(fileName);
        ArrayList<String> toReturn = MarkdownParse.getLinks(content);

        ArrayList<String> expected = new ArrayList<>();

        expected.add("example.com");

        assertEquals(expected, toReturn);
    }

    public void Snippet2Personal() throws IOException {
        Path fileName = Path.of("snippet2.md");
        String content = Files.readString(fileName);
        ArrayList<String> toReturn = MarkdownParse.getLinks(content);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("a.com");
        expected.add("a.com");
        expected.add("example.com");

        assertEquals(expected, toReturn);
    }

    public void Snippet3Personal() throws IOException {
        Path fileName = Path.of("snippet3.md");
        String content = Files.readString(fileName);
        ArrayList<String> toReturn = MarkdownParse.getLinks(content);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");

        assertEquals(expected, toReturn);
    }

    // Other Repo
    public void Snippet1ReviewRepo() throws IOException {
        Path fileName = Path.of("snippet1.md");
        String content = Files.readString(fileName);
        ArrayList<String> toReturn = RevMarkdownParse.getLinks(content);

        ArrayList<String> expected = new ArrayList<>();

        expected.add("example.com");

        assertEquals(expected, toReturn);
    }

    public void Snippet2ReviewRepo() throws IOException {
        Path fileName = Path.of("snippet2.md");
        String content = Files.readString(fileName);
        ArrayList<String> toReturn = RevMarkdownParse.getLinks(content);

        ArrayList<String> expected = new ArrayList<>();

        expected.add("a.com");
        expected.add("a.com");
        expected.add("example.com");

        assertEquals(expected, toReturn);
    }

    public void Snippet3ReviewRepo() throws IOException {
        Path fileName = Path.of("snippet3.md");
        String content = Files.readString(fileName);
        ArrayList<String> toReturn = RevMarkdownParse.getLinks(content);

        ArrayList<String> expected = new ArrayList<>();

        expected.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");

        assertEquals(expected, toReturn);
    }

}
