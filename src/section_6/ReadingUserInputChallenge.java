package section_6;

import java.util.Scanner;

public class ReadingUserInputChallenge {
    public static void main(String[] args) {
        System.out.println(sumNumbers());
    }

    public static int checkData(int number) {
        if (number < 0) return -1;
        return number;
    }

    public static int sumNumbers() {
        int sum = 0;
        int count = 1;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("Enter number #" + count + ":");
                int num = Integer.parseInt(scanner.nextLine());
                if (checkData(num) < 0) {
                    System.out.println("Invalid Value");
                } else {
                    sum += num;
                    count++;
                }
            } catch (NumberFormatException badNumber) {
                System.out.println("Invalid Value");
            }
        } while (count <= 5);

        return sum;
    }
}
