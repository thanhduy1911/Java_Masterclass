package dev.duyhvt.section_10.LinkedListChallenge;

import java.util.LinkedList;
import java.util.Scanner;

record Place(String name, int distance) {
    @Override
    public String toString() {
        return String.format("%s (%d)", name, distance);
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList<Place> placesToVisit = new LinkedList<>();
        Place hcm = new Place("Adelaide", 1374);
        addPlace(placesToVisit, hcm);
        addPlace(placesToVisit, new Place("adelaide", 1374));
        addPlace(placesToVisit, new Place("Brisbane", 917));
        addPlace(placesToVisit, new Place("Perth", 3923));
        addPlace(placesToVisit, new Place("Alice Springs", 2771));
        addPlace(placesToVisit, new Place("Darwin", 3972));
        addPlace(placesToVisit, new Place("Melbourne", 877));

        placesToVisit.addFirst(new Place("Sydney", 0));

        System.out.println(placesToVisit);

        var iterator = placesToVisit.listIterator();
        Scanner sc = new Scanner(System.in);
        boolean quitLoop = false;
        boolean forward = true;

        printMenu();

        while (!quitLoop) {
            if (!iterator.hasPrevious()) {
                System.out.println("Originating: " + iterator.next());
                forward = true;
            }

            if (!iterator.hasNext()) {
                System.out.println("Final: " + iterator.previous());
                forward = false;
            }

            System.out.print("Enter Value: ");
            String menuItem = sc.nextLine().toUpperCase().substring(0, 1);

            switch (menuItem) {
                case "F":
                    System.out.println("User want to go forward");

                    if (!forward) { // Reversing Direction
                        forward = true;
                        if (iterator.hasNext()) {
                            iterator.next(); // Adjust position forward
                        }
                    }

                    if (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                    break;
                case "B":
                    System.out.println("User want to go backward");

                    if (forward) { // Reversing Direction
                        forward = false;
                        if (iterator.hasPrevious()) {
                            iterator.previous(); // Adjust position backward
                        }
                    }

                    if (iterator.hasPrevious()) {
                        System.out.println(iterator.previous());
                    }
                    break;
                case "L":
                    System.out.println(placesToVisit);
                    break;
                case "M":
                    printMenu();
                    break;
                default:
                    quitLoop = true;
            }
        }
    }

    private static void addPlace(LinkedList<Place> list, Place place) {
        if (list.contains(place)) {
            System.out.println("Found Duplicated: " + place);
            return;
        }

        for (Place p : list) {
            if (p.name().equalsIgnoreCase(place.name())) {
                System.out.println("Found Duplicated: " + place);
                return;
            }
        }

        int matchedIndex = 0;
        for (var listIndex: list) {
            if (place.distance() < listIndex.distance()) {
                list.add(matchedIndex, place);
                return;
            }

            matchedIndex++;
        }

        list.add(place);
    }

    private static void printMenu() {
        String menu = """
                Available actions (select word or letter):
                (F)orward
                (B)ackwards
                (L)ist Places
                (M)enu
                (Q)uit""";
        System.out.println(menu);
    }
}
