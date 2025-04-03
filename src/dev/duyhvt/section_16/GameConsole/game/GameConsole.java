package dev.duyhvt.section_16.GameConsole.game;

import java.util.Scanner;

public final class GameConsole<T extends Game<? extends Player>> {
    private final T game;
    private static final Scanner scanner = new Scanner(System.in);

    public GameConsole(T game) {
        this.game = game;
    }

    public int addPlayer() {
        System.out.print("Enter your playing name: ");
        String name = scanner.nextLine();

        System.out.printf("Welcome to %s, %s%n", game.getGameName(), name);
        return game.addPlayer(name);
    }

    public void playGame(int playerIndex) {
        boolean done = false;
        while (!done) {
            var gameActions = game.getGameAction(playerIndex);
            System.out.println("Select from the one of the following actions: ");
            for (Character c : gameActions.keySet()) {
                String prompt = gameActions.get(c).prompt();
                System.out.println("\t" + prompt + " (" + c + ")");
            }
            System.out.print("Enter next action: ");

            char nextMove = scanner.nextLine().toUpperCase().charAt(0);
            GameAction gameAction = gameActions.get(nextMove);

            if (gameAction != null) {
                System.out.println("-".repeat(70));
                done = game.executeGameAction(playerIndex, gameAction);
                if (!done) {
                    System.out.println("-".repeat(70));
                }
            }
        }
    }
}
