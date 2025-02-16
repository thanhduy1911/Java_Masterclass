package dev.duyhvt.section_9.Arrays.MinimumElementChallenge;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //System.out.print("Enter the length: ");
        //int length = scanner.nextInt();

        int[] intArray = readIntegers();
        System.out.println(Arrays.toString(intArray));
        System.out.println("_".repeat(20));
        System.out.println("Minimum value is: " + findMin(intArray));
        System.out.println("_".repeat(20));
        System.out.println("Minimum value in another way is: " + findMinAlter(intArray));
    }

    // Read from Input with Length argument
    private static int[] readIntegers(int length) {
        Scanner scanner = new Scanner(System.in);
        int[] newInt = new int[length];

        for (int i = 0; i < length; i++) {
            System.out.print("Enter int value at index" + i + " : ");
            newInt[i] = scanner.nextInt();
        }

        System.out.println("The array has been created.");
        System.out.println("_".repeat(20));
        System.out.println("Array: " + Arrays.toString(newInt));

        return newInt;
    }

    // Read from Input without argument
    private static int[] readIntegers() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a list of integers, separated by commas: ");
        String input = scanner.nextLine();

        String[] splits = input.split(",");
        int[] values = new int[splits.length];

        for (int i = 0; i < splits.length; i++) {
            values[i] = Integer.parseInt(splits[i].trim());
        }

        return values;
    }

    // Find minimum value in the array
    private static int findMin(int[] array) {
        // Copy array for safety
        int[] copyArray = Arrays.copyOf(array, array.length);
        // Sort it
        Arrays.sort(copyArray);

        return copyArray[0]; // the first index always a min number in the array
    }

    // Find minimum value in the array (Alternative method)
    private static int findMinAlter(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int element : array) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }
}
