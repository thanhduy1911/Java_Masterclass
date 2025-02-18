package dev.duyhvt.section_10.ArrayListChallenge;

import dev.duyhvt.utilities.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String title = "Array List Challenge";
        Utils.printHeader(title);

        menu();
        ArrayList<String> groceryList = new ArrayList<>();

        readInputData(groceryList);
    }

    private static void readInputData(ArrayList<String> groceryList) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter a number for which action you want to do: ");

                int number = sc.nextInt();
                sc.nextLine();

                if (number == 0) break;

                System.out.print("Input your item: ");
                String input = sc.nextLine().trim();
                String[] items = input.split(",");
                for (int i = 0; i < items.length; i++) {
                    items[i] = items[i].trim();
                }

                if (number == 1) {
                    for (String item : items) {
                        if (!groceryList.contains(item)) {
                            groceryList.add(item);
                            System.out.println("Added --> " + item);
                        } else {
                            System.out.println("Duplicated item ignored: " + item);
                        }
                    }
                    System.out.println("Your new list --> " + groceryList);
                } else if (number == 2) {
                    for (String item : items) {
                        if (groceryList.contains(item)) {
                            groceryList.remove(item);
                            System.out.println("Removed --> " + item);
                        } else {
                            System.out.println("Item not found: " + item);
                        }
                    }
                    System.out.println("Your new list --> " + groceryList);
                } else {
                    System.out.println("Invalid number, please enter 1, 2, or 0.");
                }
            } catch (Exception e) {
                System.out.println("Invalid integer value, try again.");
                sc.nextLine();
            }
            System.out.println("_".repeat(30));
        }
        sc.close();
    }

    private static void menu() {
        String body = """
                Available actions:
                0 - to shutdown
                1 - to add item(s) to list (comma delimited list)
                2 - to remove any items (comma delimited list)""";
        System.out.println(body);
    }
}
