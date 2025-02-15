package dev.duyhvt.section_6;

public class NumberToWords {
    public static void main(String[] args) {
        //System.out.println(getDigitCount(3021)); --> Test purpose
        //System.out.println(reverse(12351)); --> Test purpose
        System.out.println(numberToWords(123));
        System.out.println(numberToWords(1010));
        System.out.println(numberToWords(1000));
        System.out.println(numberToWords(-123));
    }

    public static int getDigitCount(int number) {
        if (number < 0) return -1;
        else if (number == 0) return 1;
        else {
            int count = 0;
            while (number > 0) {
                number /= 10;
                count++;
            }
            return count;
        }
    }

    public static int reverse(int number) {
        int rev = 0;
        while (number != 0) {
            rev = (rev * 10) + (number % 10);
            number /= 10;
        }
        return rev;
    }

    public static String numberToWords(int number) {
        if (number < 0) System.out.println("Invalid Value");
        else if (number == 0) System.out.println("Zero");

        int reverseNumber = reverse(number);
        int reverseDigitCount = getDigitCount(reverseNumber);
        int numberDigitCount = getDigitCount(number);
        int differentCount = numberDigitCount - reverseDigitCount;

        while (reverseNumber > 0) {
            switch (reverseNumber % 10) {
                case 0 -> System.out.println("Zero");
                case 1 -> System.out.println("One");
                case 2 -> System.out.println("Two");
                case 3 -> System.out.println("Three");
                case 4 -> System.out.println("Four");
                case 5 -> System.out.println("Five");
                case 6 -> System.out.println("Six");
                case 7 -> System.out.println("Seven");
                case 8 -> System.out.println("Eight");
                case 9 -> System.out.println("Nine");
            }
            reverseNumber /= 10;
        }
        while (differentCount > 0) {
            System.out.println("Zero");
            differentCount--;
        }
        return "";
    }
}
