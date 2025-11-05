package dev.duyhvt.section_16.GameConsole;

import dev.duyhvt.section_16.GameConsole.game.GameConsole;
import dev.duyhvt.section_16.GameConsole.pirate.PirateGame;

public class Main {
    public static void main(String[] args) {
//        var console = new GameConsole<>(new ShooterGame("The Shooter Game"));

//        int playerIndex = console.addPlayer();
//        console.playGame(playerIndex);
//        Weapon weapon = Weapon.getWeaponByChar('P');
//        System.out.println("weapon = " + weapon + ", hitPoints = " +
//                weapon.getHitPoints() + ", minLevel = " + weapon.getMinLevel());
//        var list = Weapon.getWeaponsByLevel(1);
//        list.forEach(System.out::println);
//
//        Pirate duy = new Pirate("Duyhvt");
//        System.out.println(duy);
//
//        PirateGame.getTowns(0).forEach(t -> System.out.println(t.information()));
//        System.out.println("-".repeat(70));
//        PirateGame.getTowns(1).forEach(t -> System.out.println(t.information()));

        var console = new GameConsole<>(new PirateGame("The Pirate Game"));
        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);
    }
}
