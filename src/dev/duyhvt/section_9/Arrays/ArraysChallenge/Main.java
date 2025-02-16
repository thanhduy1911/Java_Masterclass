package dev.duyhvt.section_9.Arrays.ArraysChallenge;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] newInt = generateInt(5);
        System.out.println(Arrays.toString(newInt));

        int[] sortedArray = sortInt(new int[] {7,30,35});
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] generateInt(int len) {
        Random random = new Random();
        int[] newInt = new int[len];
        for (int i = 0; i < newInt.length; i++) {
            newInt[i] = random.nextInt(1000);
        }
        return newInt;
    }

    public static int[] sortInt(int[] array) {
        System.out.println(Arrays.toString(array));
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                    System.out.println("-------->" + Arrays.toString(sortedArray));
                }
            }
            System.out.println(("--->" + Arrays.toString(sortedArray)));
        }
        return sortedArray;
    }
}
