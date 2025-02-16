package dev.duyhvt.section_9.Arrays.SortedArray;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        int[] unSortArray = getInteger(5);
//        System.out.println(Arrays.toString(unSortArray));
//        int[] sortArray = sortDescIntTemp(unSortArray);
//        System.out.println(Arrays.toString(sortArray));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of number: ");

        int len = scanner.nextInt();
        int[] unSortArray = getInteger(len);
        int[] sortArray = sortDescInt(unSortArray);
        printArray(sortArray);
    }
    // Get new Integers
    public static int[] getInteger(int capacity) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[capacity];
        System.out.println("Enter " + capacity + " integer values:\r");
        for (int i=0; i<array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }
    // Sort Array Descending For Testing
    public static int[] sortDescIntTemp(int[] intArray) {
        // Copy to a new array
        int[] sortInt = Arrays.copyOf(intArray, intArray.length);
        int temp; // hold the swap number
        boolean flag = true; // signal to stop the loop

        while (flag) {
            flag = false;
            for (int i = 0; i < sortInt.length - 1; i++) {
                if (sortInt[i] < sortInt[i + 1]) {
                    temp = sortInt[i]; // holding the swap i
                    sortInt[i] = sortInt[i + 1]; // swap the min i ---> i + 1 because i + 1 > i (position)
                    sortInt[i + 1] = temp; // swap position i + 1 ---> i
                    flag = true; // continue the loop...
                    System.out.println("------->" + Arrays.toString(sortInt));
                }
            }
            System.out.println("--->" + Arrays.toString(sortInt));
        }
        return sortInt;
    }
    // Sort Array Descending For Udemy Passing
    public static int[] sortDescInt(int[] intArray) {
        // Copy to a new array
        int[] sortInt = Arrays.copyOf(intArray, intArray.length);
        int temp; // hold the swap number
        boolean flag = true; // signal to stop the loop

        while (flag) {
            flag = false;
            for (int i = 0; i < sortInt.length - 1; i++) {
                if (sortInt[i] < sortInt[i + 1]) {
                    temp = sortInt[i]; // holding the swap i
                    sortInt[i] = sortInt[i + 1]; // swap the min i ---> i + 1 because i + 1 > i (position)
                    sortInt[i + 1] = temp; // swap position i + 1 ---> i
                    flag = true; // continue the loop...
                }
            }
        }
        return sortInt;
    }
    // Sort Array Descending Using QuickSort
    public static int[] quickSort(int[] intArray) {
        Arrays.sort(intArray);

        int[] newArray = new int[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            newArray[i] = intArray[intArray.length - 1 - i];
        }

        return newArray;
    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }
}
