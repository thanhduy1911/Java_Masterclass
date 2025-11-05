package dev.duyhvt.section_8.Encapsulation;

public class Main {
    public static void main(String[] args) {
//        Player player = new Player();
//        player.fullName = "Duy";
//        player.health = 20;
//        player.weapon = "Sword";
//
//        int dmg = 10;
//        player.loseHealth(dmg);
//        System.out.println("Remaining health = " + player.healthRemaining());
//
//        player.loseHealth(11);
//        System.out.println("Remaining health = " + player.healthRemaining());

        EnhancedPlayer duy = new EnhancedPlayer("Duy","Sword", 200);
        System.out.println("Initial health is " + duy.healthRemaining());
    }
}
