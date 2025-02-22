package dev.duyhvt.section_11.Interfaces;

public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnable flier = bird;
        Trackable tracked = bird;

        animal.move();
//        flier.takeOff();
//        flier.fly();
//        tracked.track();
//        flier.land();
        inFlight(flier);
        inFlight(new Jet());
        Trackable truck = new Truck();
        truck.track();

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnable.KM_TO_MILES;
        System.out.printf("The truck traveled %.2f km or %.2f miles%n",
                kmsTraveled, milesTraveled);
    }

    private static void inFlight(FlightEnable flier) {
        flier.takeOff();
        flier.fly();
        if (flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }
}
