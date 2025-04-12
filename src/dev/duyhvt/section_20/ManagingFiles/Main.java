package dev.duyhvt.section_20.ManagingFiles;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) {
//        File oldFile = new File("src/dev/duyhvt/section_20/files/students.json");
//        File newFile = new File("src/dev/duyhvt/section_20/files/students-activity.json");
//        if (oldFile.exists()) {
//            oldFile.renameTo(newFile);
//            System.out.println("File renamed to " + newFile.getAbsolutePath() + " successfully");
//        } else {
//            System.out.println("File does not exist");
//        }

//        Path oldPath = Path.of("src/dev/duyhvt/section_20/files/students.json");
//        Path newPath = Path.of("src/dev/duyhvt/section_20/files/file/student-activity.json");
//
//        try {
//            Files.createDirectories(newPath.subpath(0, newPath.getNameCount() -1));
//            Files.move(oldPath, newPath);
//            System.out.println(oldPath + " moved (renamed to) --> " + newPath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Path fileDir = Path.of("src/dev/duyhvt/section_20/files");
        Path resourceDir = Path.of("src/dev/duyhvt/section_20/resources");
        try {
            recurseDelete(resourceDir);
            recurseCopy(fileDir, resourceDir);
            System.out.println("Directory copied to " + resourceDir);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try (BufferedReader reader = new BufferedReader(
//                new FileReader("src/dev/duyhvt/section_20/files/file/student-activity.json"));
//        PrintWriter writer = new PrintWriter("src/dev/duyhvt/section_20/files/students-backup.json")) {
//            reader.transferTo(writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String urlString = "https://api.census.gov/data/2019/pep/charagegroups?get=NAME,POP&for=state:*";
        URI uri = URI.create(urlString);
        try (var urlInputStream = uri.toURL().openStream();) {
            urlInputStream.transferTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path jsonPath = Path.of("src/dev/duyhvt/section_20/USPopulationByState.txt");
        try (var reader = new InputStreamReader(uri.toURL().openStream());
             var writer = Files.newBufferedWriter(jsonPath)) {
            reader.transferTo(writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (var reader = new InputStreamReader(uri.toURL().openStream());
             PrintWriter writer = new PrintWriter("src/dev/duyhvt/section_20/USPopulationByState.csv")) {
            reader.transferTo(new Writer() {
                @Override
                public void write(char[] cbuf, int off, int len) throws IOException {
                    String jsonString = new String(cbuf, off, len).trim();
                    jsonString = jsonString.replace('[', ' ').trim();
                    jsonString = jsonString.replaceAll("\\]", "");
                    writer.write(jsonString);
                }

                @Override
                public void flush() throws IOException {
                    writer.flush();
                }

                @Override
                public void close() throws IOException {
                    writer.close();
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void recurseCopy(Path source, Path target) throws IOException {
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        if (Files.isDirectory(source)) {
            try (var children = Files.list(source)) {
                children.toList().forEach(
                        path -> {
                            try {
                                Main.recurseCopy(
                                        path, target.resolve(path.getFileName()));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
            }
        }
    }

    public static void recurseDelete(Path target) throws IOException {
        if (Files.isDirectory(target)) {
            try (var children = Files.list(target)) {
                children.toList().forEach(
                        path -> {
                            try {
                                Main.recurseDelete(path);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
            }
        }
        Files.delete(target);
    }
}
