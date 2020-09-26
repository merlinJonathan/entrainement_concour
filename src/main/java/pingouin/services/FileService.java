package pingouin.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {
	public static List<String> readFile(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .collect(Collectors.toList());
    }

    public static void writeFile(List<String> lines, String filePath) throws IOException {
        Files.write(Paths.get(filePath), lines);
    }

    public static void appendFile(List<String> lines, String filePath) throws IOException {
        Files.write(Paths.get(filePath), lines, StandardOpenOption.APPEND);
    }
}
