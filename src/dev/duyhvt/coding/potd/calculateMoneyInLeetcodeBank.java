package dev.duyhvt.coding.potd;

public class calculateMoneyInLeetcodeBank {
    private static int totalMoney(int n) {
        int total = 0;
        int monday = 1;
        int dayMoney = monday;

        for (int i = 1; i <= n; i++) {
            total += dayMoney;
            dayMoney++;

            if (i % 7 == 0) {
                monday++;
                dayMoney = monday;
            }
        }

        return total;
    }
    public static void main(String[] args) {
        System.out.println(totalMoney(5));
        System.out.println(totalMoney(10));
        System.out.println(totalMoney(4));
        System.out.println(totalMoney(20));
    }
}
