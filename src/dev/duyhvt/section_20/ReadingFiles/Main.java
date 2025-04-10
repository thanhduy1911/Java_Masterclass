package dev.duyhvt.section_20.ReadingFiles;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("D:\\Learning\\Java\\UltimateClass\\Java_Masterclass\\src\\dev\\duyhvt\\section_20\\ReadingFiles\\file.txt")) {
            char[] block = new char[1000];
            int data;
            while ((data = reader.read(block)) != - 1) {
                String content = new String(block, 0, data);
                System.out.printf("---> [%d chars] %s %n", data, content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
