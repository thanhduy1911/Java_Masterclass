package section_6;

public class SharedDigit {
    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12, 23));
        System.out.println(hasSharedDigit(9, 99));
        System.out.println(hasSharedDigit(15, 55));
        System.out.println(hasSharedDigit(12, 56));
    }

    public static boolean hasSharedDigit(int firstNumber, int secondNumber) {
        if (firstNumber >= 10 && firstNumber <= 99 && secondNumber >= 10 && secondNumber <= 99) {
            for (int i = firstNumber; i > 0; i /= 10) {
                for (int j = secondNumber; j > 0; j /= 10) {
                    if (i % 10 == j % 10) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
