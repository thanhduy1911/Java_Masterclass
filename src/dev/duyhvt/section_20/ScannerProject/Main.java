package dev.duyhvt.section_20.ScannerProject;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileReader("src/dev/duyhvt/section_20/files/fixedWidth.txt"))) {
//            while (scanner.hasNextLine()) {
//                System.out.println(scanner.nextLine());
//            }
//            System.out.println(scanner.delimiter());
//            scanner.useDelimiter("$");
//            scanner.tokens().forEach(System.out::println);

//            scanner.findAll("[A-Za-z]{10,}")
//                    .map(MatchResult::group)
//                    .distinct()
//                    .sorted()
//                    .forEach(System.out::println);
            var results = scanner.findAll(
                    "(.{15})(.{3})(.{12})(.{8})(.{2}).*")
                    .skip(1)
                    .map(m -> m.group(3).trim())
                    .distinct()
                    .sorted()
                    .toArray(String[]::new);

            System.out.println(Arrays.toString(results));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
