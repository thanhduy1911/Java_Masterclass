package dev.duyhvt.section_5;

public class IntEqualityCalculator {
    public static void main(String[] args) {
        IntEqualityPrinter(1,1,1);
        IntEqualityPrinter(1,1,2);
        IntEqualityPrinter(-1,-1,-1);
        IntEqualityPrinter(1,2,3);
    }

    public static void IntEqualityPrinter (int first, int second, int third) {
        String invalid = "invalid Value";
        String diff = "All numbers are different";
        String equal = "All numbers are equal";
        String neither = "Neither all are equal or different";

        if (first < 0 || second < 0 || third < 0) {
            System.out.println(invalid);
        } else if ((first != second) && (first != third) && (second != third)) {
            System.out.println(diff);
        } else if (first == second && first == third) {
            System.out.println(equal);
        } else {
            System.out.println(neither);
        }
    }
}
