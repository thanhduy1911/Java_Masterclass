package dev.duyhvt.section_11.Interfaces;

import java.util.LinkedList;
import java.util.List;

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

        LinkedList<FlightEnable> fliers = new LinkedList<>();
        fliers.add(bird);

        List<FlightEnable> betterFliers = new LinkedList<>();
        betterFliers.add(bird);

        triggerFliers(fliers);
        flyFliers(fliers);
        landFliers(fliers);

        triggerFliers(betterFliers);
        flyFliers(betterFliers);
        landFliers(betterFliers);
    }

    private static void inFlight(FlightEnable flier) {
        flier.takeOff();
        flier.fly();
        if (flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }

    private static void triggerFliers(List<FlightEnable> fliers) {
        for (var flier : fliers) {
            flier.takeOff();
        }
    }

    private static void flyFliers(List<FlightEnable> fliers) {
        for (var flier : fliers) {
            flier.fly();
        }
    }

    private static void landFliers(List<FlightEnable> fliers) {
        for (var flier : fliers) {
            flier.land();
        }
    }
}
