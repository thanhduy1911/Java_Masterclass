package section_5;

public class MinutesToYearsDaysCalculator {
    public static void main(String[] args) {
        printYearsAndDays(525600);
        printYearsAndDays(1051200);
        printYearsAndDays(561600);
    }

    public static void printYearsAndDays (long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
        }

        long years = minutes / (60 * 24 * 365);
        long remainDays = (minutes / (60*24)) % 365;

        System.out.println(minutes + " min = " + years + " y and " + remainDays + " d" );
    }
}
