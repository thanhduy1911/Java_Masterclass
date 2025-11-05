package dev.duyhvt.section_6;

public class NumberOfDaysInMonth {
    public static void main(String[] args) {
        System.out.println(getDaysInMonth(1, 2020));
        System.out.println(getDaysInMonth(2, 2020));
        System.out.println(getDaysInMonth(2, 2018));
        System.out.println(getDaysInMonth(-1, 2020));
        System.out.println(getDaysInMonth(1, -2020));
    }

    public static boolean isLeapYear(int year) {
        return year >= 1 && year <= 9999 && (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public static int getDaysInMonth(int month, int year) {
        if (year >= 1 && year <= 9999 && month >= 1 && month <= 12) {
            return switch (month) {
                case 2 -> isLeapYear(year) ? 29 : 28;
                case 4,6,9,11 -> 30;
                default -> 31;
            };
        }
        return -1;
    }
}
