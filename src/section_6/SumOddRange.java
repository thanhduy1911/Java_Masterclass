package section_6;

public class SumOddRange {
    public static void main(String[] args) {
        System.out.println(sumOdd(1, 100));
        System.out.println(sumOdd(-1, 100));
        System.out.println(sumOdd(100, 100));
        System.out.println(sumOdd(13, 13));
        System.out.println(sumOdd(100, -100));
        System.out.println(sumOdd(100, 1000));
    }

    public static boolean isOod(int number) {
        return (number > 0) && (number % 2 == 0);
    }

    public static int sumOdd(int start, int end) {
        int sum = 0;
        if (start < 0 || (start > end)) {
            return -1;
        }

        int oddStart = isOod(start) ? start : start + 1;
        for (int i = oddStart; i <= end; i+= 2) {
            sum += i;
        }
        return sum;
    }
}
