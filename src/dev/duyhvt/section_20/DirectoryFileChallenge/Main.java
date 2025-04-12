package dev.duyhvt.section_20.DirectoryFileChallenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path challengePath = Path.of("src", "dev", "duyhvt", "section_20", "DirectoryFileChallenge", "public", "assets", "icons");

        try {
            Files.createDirectories(challengePath);
            generateIndexFile(challengePath.getParent().getParent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int publicIndex = 5;
        for (int i = publicIndex + 1; i <= challengePath.getNameCount(); i++) {
            Path indexedPath = challengePath.subpath(0, i).resolve("index.txt");
            Path backupPath = challengePath.subpath(0, i).resolve("indexCopy.txt");
            try {
                Files.copy(indexedPath, backupPath,
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            generateIndexFile(challengePath.getParent().getParent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void generateIndexFile(Path staringPath) throws IOException {
        Path indexFile = staringPath.resolve("index.txt");
        try (Stream<Path> contents = Files.find(staringPath, Integer.MAX_VALUE,
                (path, attr) -> true)) {
            String fileContents = contents
                    .map((path -> path.toAbsolutePath().toString()))
                    .collect(Collectors.joining(
                            System.lineSeparator(),
                            "Directory Contents: " + System.lineSeparator(),
                            System.lineSeparator() + "Generated: " + LocalDateTime.now()
                    ));
            Files.writeString(indexFile, fileContents, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (Stream<Path> contents = Files.list(staringPath)) {
            contents
                    .filter(Files::isDirectory)
                    .toList()
                    .forEach((dir -> {
                        try {
                            generateIndexFile(dir);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }));
        }
    }
}
