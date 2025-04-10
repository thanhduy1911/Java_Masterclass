package dev.duyhvt.section_20.FileTreeNavigationChallenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ChallengeStreams {
    public static void main(String[] args) {
        Path staringPath = Path.of(".");
        int index = staringPath.getNameCount();
        try (var paths = Files.walk(staringPath, Integer.MAX_VALUE)) {
            paths
                    .filter(Files::isRegularFile)
                    .collect(Collectors.groupingBy(p -> p.subpath(index, index + 1),
                            Collectors.summarizingLong(
                                    //p -> p.toFile().length()))) -- Alternative Approve
                                    (p -> {
                                        try {
                                            return Files.size(p);
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                    })
                            )))
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparing(e -> e.getKey().toString()))
                    //.filter(e -> e.getValue().getSum() > 50_000) -- Filter files which size > 50_000
                    .forEach(e -> System.out.printf("[%s] %,d bytes, %d files %n",
                            e.getKey(), e.getValue().getSum(),
                            e.getValue().getCount()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
