package section_6;

public class EvenDigitSum {
    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(123456789));
        System.out.println(getEvenDigitSum(252));
        System.out.println(getEvenDigitSum(-22));
    }

    public static int getEvenDigitSum(int number) {
        if (number < 0) {
            return -1;
        }

        int sumEven = 0;
        while (number > 0) {
            if (number % 2 == 0) { // Even number
                int digit = number % 10; // --> Get digit number e.g 12345 % 10 = xxx.5 --> 5 is the target digit number
                sumEven += digit;
            }
            number /= 10; // --> Next digit number e.g: 12345 / 10 = 1234
        }
        return sumEven;
    }
}
