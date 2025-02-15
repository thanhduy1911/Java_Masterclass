package dev.duyhvt.section_5;

public class MegaBytesConverter {
    public static void main(String[] args) {
        printMegaBytesAndKiloBytes(2500);
        printMegaBytesAndKiloBytes(-1024);
        printMegaBytesAndKiloBytes(5000);
    }

    private static void printMegaBytesAndKiloBytes(int kiloBytes) {
        int megaBytes = kiloBytes / 1024;
        int remainder = kiloBytes % 1024;
        if (kiloBytes < 0) {
            megaBytes = 0;
            remainder = 0;
        }
        System.out.println((kiloBytes >= 0) ? kiloBytes + " KB = " + megaBytes + " MB and " + remainder + " KB" : "Invalid Value");
    }
}
