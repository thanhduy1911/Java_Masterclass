package dev.duyhvt.section_15.AdventureMap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String customLocation = """
                lake , at the edge f Lake Tim, E:ocean, W:forest, S:well house, N: cave
                ocean, on Tim's beach before an angry sea, W:lake
                cave, at the mouth of Tim's bat cave, E:ocean, W:forest, S:lake
                """;
        AdventureGame game = new AdventureGame(customLocation);
        game.play("lake");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String direction = scanner.nextLine().trim().toUpperCase().substring(0, 1);
            if (direction.equals("Q")) {
                System.out.println("See Ya!");
                break;
            }

            game.move(direction);
        }
    }
}
