package dev.duyhvt.section_16.GameConsole.game;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ShooterGame extends Game<Shooter> {
    public ShooterGame(String gameName) {
        super(gameName);
    }

    @Override
    public Shooter createNewPlayer(String name) {
        return new Shooter(name);
    }

    @Override
    public Map<Character, GameAction> getGameAction(int playerIndex) {
        var map = new LinkedHashMap<>(Map.of(
                'F',
                new GameAction('F', "Find Prize", this::findPrize),
                'S',
                new GameAction('S', "Use your gun", this::useWeapon)
        ));
        map.putAll(getStandardActions());
        return map;
    }

    public boolean findPrize(int playerIndex) {
        return getPlayer(playerIndex).findPrize();
    }

    public boolean useWeapon(int playerIndex) {
        return getPlayer(playerIndex).useWeapon(selectWeapon());
    }

    private String selectWeapon() {
        System.out.print("Select your weapon: \n1. Pistol\n2. Gatling Gun\n3. AWM Sniper\n");
        Scanner scanner = new Scanner(System.in);
        int selectedWeapon = scanner.nextInt();
        return switch(selectedWeapon) {
            case 1 -> "Pistol";
            case 2 -> "Gatling Gun";
            case 3 -> "AWM Sniper";
            default -> "Bare hands";
        };
    }
}
