package dev.duyhvt.section_9.ArraysExercises;

/*
    Bài 1: Sắp xếp mảng số nguyên lẻ
    Đề bài: Viết một chương trình nhận một mảng số nguyên, chỉ sắp xếp các số lẻ theo thứ tự giảm dần, còn số chẵn giữ nguyên vị trí.
    Ví dụ:

    Input: [5, 3, 2, 8, 1, 4]
    Output: [5, 3, 2, 8, 1, 4] → [5, 3, 2, 8, 1, 4] → [5, 3, 2, 8, 1, 4]
*/

import dev.duyhvt.utilities.Utils;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Utils.printHeader("Sắp xếp mảng số nguyên lẻ");

        int[] array = getIntArray();
        System.out.println("Mảng trước khi sắp xếp: " + Arrays.toString(array));
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(descEvenNumber(array)));

        Utils.printFooter();
    }

    private static int[] getIntArray() {
        System.out.print("Vui lòng nhập độ dài mảng: ");
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] newInt = new int[len];

        for (int i = 0; i < newInt.length; i++) {
            try {
                System.out.print("Vui lòng nhập giá trị cho mảng tại index " + i + ": ");
                newInt[i] = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error: Invalid input, please enter a number.");
                scanner.next();
            }
        }
        System.out.println("_".repeat(30));
        return newInt;
    }

    private static int[] descEvenNumber(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        int[] oddNumber = new int[sortedArray.length];
        int oodCount = 0;
        
        for (int num : sortedArray) {
            if (num % 2 != 0) {
                oddNumber[oodCount++] = num;
            }
        }

        for (int i = 0; i < oodCount - 1; i++) {
            for (int j = i + 1; j < oodCount; j++) {
                if (oddNumber[i] < oddNumber[j]) {
                    int temp = oddNumber[i];
                    oddNumber[i] = oddNumber[j];
                    oddNumber[j] = temp;
                }
            }
        }

        int oddIndex = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] % 2 != 0) {
                sortedArray[i] = oddNumber[oddIndex++];
            }
        }

        return sortedArray;
    }
}
