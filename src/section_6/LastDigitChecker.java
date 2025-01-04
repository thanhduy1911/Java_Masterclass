package section_6;

public class LastDigitChecker {
    public static void main(String[] args) {
        System.out.println(lastDigitChecker(41,22,71));
        System.out.println(lastDigitChecker(23,32,42));
        System.out.println(lastDigitChecker(9,99,999));
    }

    public static boolean isValid(int number) {
        return number >= 10 && number <= 1000;
    }

    public static boolean lastDigitChecker(int number1, int number2, int number3) {
        return (isValid(number1) && isValid(number2) && isValid(number3)) && (number1 % 10 == number2 % 10 || number1 % 10 == number3 % 10 || number2 % 10 == number3 % 10);
    }
}
