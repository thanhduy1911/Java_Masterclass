package dev.duyhvt.section_5;

public class PlayingCat {
    public static void main(String[] args) {
        System.out.println(isCatPlaying(true, 10));
        System.out.println(isCatPlaying(false, 36));
        System.out.println(isCatPlaying(false, 35));
        System.out.println(isCatPlaying(true, 44));
    }

    public static boolean isCatPlaying (boolean isSummer, int temp) {
        return temp >= 25 && temp <= (isSummer ? 45 : 35);
    }
}
