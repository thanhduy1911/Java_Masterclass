package section_6;

public class DiagonalStar {
    public static void main(String[] args) {
        int number = 5;
        if (number < 5) {
            System.out.println("Invalid Value");
        } else {
            for (int i = 1; i <= number; i++) { // i: Current row
                for (int j = 1; j <= number; j++) { // j: Column count
                    if (i == 1 || i == number || j == 1 || j == number || j == number - i + 1 || i == j) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
