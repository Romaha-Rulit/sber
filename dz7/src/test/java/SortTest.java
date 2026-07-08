import org.example.Main;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SortNamesTest {

    @TempDir
    Path tempDir;

    @Test
    void basicAlphabeticalSort() throws Exception {
        Path input = tempDir.resolve("names.txt");
        Path output = tempDir.resolve("sorted.txt");
        Files.write(input, Arrays.asList("вова", "саня", "леха"));

        List<String> result = Main.sortNames(input.toString(), output.toString());

        assertEquals(Arrays.asList("вова", "леха", "саня"), result);
    }

    @Test
    void skipsEmptyLines() throws Exception {
        Path input = tempDir.resolve("names.txt");
        Path output = tempDir.resolve("sorted.txt");
        Files.write(input, Arrays.asList("", "рома", "", "дима", ""));

        List<String> result = Main.sortNames(input.toString(), output.toString());

        assertEquals(Arrays.asList("дима", "рома"), result);
    }

    @Test
    void emptyFileReturnsEmptyList() throws Exception {
        Path input = tempDir.resolve("names.txt");
        Path output = tempDir.resolve("sorted.txt");
        Files.write(input, List.of());

        List<String> result = Main.sortNames(input.toString(), output.toString());

        assertTrue(result.isEmpty());
    }
}
