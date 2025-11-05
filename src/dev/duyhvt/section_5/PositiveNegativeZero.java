package dev.duyhvt.section_5;

public class PositiveNegativeZero {
    public static void main(String[] args) {
        checkNumber(2);
        checkNumber(-1);
        checkNumber(0);
    }
    public static void checkNumber(int number) {
        System.out.println((number > 0) ? "Positive" : (number < 0) ? "Negative" : "Zero");
    }
}
