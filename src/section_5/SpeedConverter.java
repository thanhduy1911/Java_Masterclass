package section_5;

public class SpeedConverter {
    public static void main(String[] args) {
        printConversion(1.5);
        printConversion(10.25);
        printConversion(-5.6);
        printConversion(25.42);
        printConversion(75.114);
    }
    public static long toMilesPerHour (double kilometersPerHour) {
        if (kilometersPerHour >= 0) {
            double cal = kilometersPerHour / 1.609d;
            return Math.round(cal);
        }
        return -1;
    }

    public static void printConversion (double kilometersPerHour) {
        System.out.println((toMilesPerHour(kilometersPerHour) >= 0) ? kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h": "Invalid Value");
    }
}
