package dev.duyhvt.coding.math.simulation;

public class CountOperationsToObtainZero {
    public static int countOperations(int num1, int num2) {
        int res = 0;
        while (Math.min(num1, num2) > 0) {
            if (num1 < num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }

            res += num1 / num2;
            num1 %= num2;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(countOperations(2, 3));
        System.out.println(countOperations(10, 10));
    }
}
