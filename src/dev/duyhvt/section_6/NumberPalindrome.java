package dev.duyhvt.section_6;

public class NumberPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));
        System.out.println(isPalindrome(707));
        System.out.println(isPalindrome(11212));
    }

    public static boolean isPalindrome(int number) {
        int reverse = 0;
        int numberToProcess = number;

        while (numberToProcess != 0) {
            reverse = reverse * 10 + numberToProcess % 10;
            numberToProcess /= 10;
        }
        return reverse == number;
    }
}
