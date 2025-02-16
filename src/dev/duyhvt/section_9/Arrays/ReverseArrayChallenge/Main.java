package dev.duyhvt.section_9.Arrays.ReverseArrayChallenge;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = getIntegers(6);
        reverseArray(array);
    }

    private static void reverseArray(int[] array) {
        // Copy for safety
        int[] reversedArray = Arrays.copyOf(array ,array.length);
        int maxIndex = array.length - 1;
        int haftLength = array.length / 2;

        for (int i = 0; i < haftLength; i++) {
            int temp = reversedArray[i];
            reversedArray[i] = reversedArray[maxIndex - i];
            reversedArray[maxIndex -  i] = temp;
            System.out.println("--> " + Arrays.toString(reversedArray));
        }
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("_".repeat(20));
        System.out.println("Reversed Array: " + Arrays.toString(reversedArray));
    }

    public static int[] getIntegers(int len) {
        Random random = new Random();
        int[] newInt = new int[len];
        for (int i = 0; i < newInt.length; i++) {
            newInt[i] = random.nextInt(1000);
        }
        return newInt;
    }
}
