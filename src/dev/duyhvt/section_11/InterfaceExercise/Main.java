package dev.duyhvt.section_11.InterfaceExercise;

public class Main {
    public static void main(String[] args) {
        Player aether = new Player("Aether", 10, 15);
        Player lumine = new Player("Lumine", 12, 13);

        Monster hilichurl = new Monster("Hilichurl", 3, 20);
        Monster werewolf = new Monster("Werewolf", 20, 40);

        System.out.println(aether);
        System.out.println(werewolf);
    }
}
