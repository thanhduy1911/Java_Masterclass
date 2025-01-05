package section_6;

import java.util.Scanner;

public class MinAndMaxChallenge {
    public static void main(String[] args) {
        double max = 0;
        double min = 0;
        int loopCount = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a valid number, or any character to exit.");
            String nextEntry = scanner.nextLine();

            try {
                double validNum = Double.parseDouble(nextEntry);
                if (loopCount < 0 || validNum < min) {
                    min = validNum;
                }
                if (loopCount == 0 || validNum > max) {
                    max = validNum;
                }
                loopCount++;
            } catch (NumberFormatException nfe) {
                break;
            }
        }

        if (loopCount > 0) {
            System.out.println("Min = " + min + ", max = " + max);
        } else {
            System.out.println("No valid data entered");
        }
    }
}
