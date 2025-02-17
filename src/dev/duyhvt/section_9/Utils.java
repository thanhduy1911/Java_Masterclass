package dev.duyhvt.section_9;

import java.util.Random;
import java.util.Scanner;

public class Utils {
    private static final String SEPARATOR = "_".repeat(40);

    // Header
    public static void printHeader(String title) {
        System.out.println(SEPARATOR);
        System.out.println(title);
        System.out.println(SEPARATOR);
    }

    // Footer
    public static void printFooter() {
        System.out.println(SEPARATOR);
    }

    // Get Array Type Int
    public static int[] getIntArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input array length: ");
        int len = scanner.nextInt();
        int[] intArray = new int[len];

        for (int i = 0; i < len; i++) {
            System.out.print("Input the element at the index " + i + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("⚠️ Invalid input, please enter a valid integer.");
                scanner.next(); // Loại bỏ dữ liệu sai
            }
            intArray[i] = scanner.nextInt();
        }
        return intArray;
    }

    // Get Random Array Type Int
    public static int[] getRandomIntArray() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Please input array length: ");
        int len = scanner.nextInt();
        int[] intRandomArray = new int[len];

        for (int i = 0; i < len; i++) {
            intRandomArray[i] = random.nextInt(1000);
        }
        return intRandomArray;
    }
}
