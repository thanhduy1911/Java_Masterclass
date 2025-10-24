package dev.duyhvt.coding;

public class nextGreaterNumericallyBalancedNumber {
    private static int solution(int n) {
        for (int i = n + 1; i <= 1244444; i++) {
            if (isBeautiful(i)) {
                return i;
            }
        }

        return -1;

    }

    private static boolean isBeautiful(int x) {
        int[] count = new int[10];
        while (x > 0) {
            count[x % 10]++;
            x /= 10;
        }

        for (int d = 0; d < 10; ++d) {
            if (count[d] > 0 && count[d] != d) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(1000));
        System.out.println(solution(3000));
    }
}
