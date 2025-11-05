package dev.duyhvt.section_6;

import java.util.Scanner;

public class InputCalculator {
    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }

    public static void inputThenPrintSumAndAverage() {
        int sum = 0;
        long average;
        int loopCount = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter valid number or a character to exit: ");
            String nextEntry = scanner.nextLine();
            try {
                int validNumber = Integer.parseInt(nextEntry);
                sum += validNumber;
                loopCount++;
            } catch (NumberFormatException nfe) {
                break;
            }
        }
        average = Math.round((double)sum/loopCount);
        System.out.println("SUM = " + sum + " AVG = " + Math.round(average));
    }
}
