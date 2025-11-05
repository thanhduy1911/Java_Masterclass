package dev.duyhvt.coding.potd;

public class checkIfDigitsAreEqualInStringAfterOperationsI {
    private static boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            StringBuilder next = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i++) {
                int sum = (s.charAt(i) + s.charAt(i + 1)) % 10;
                next.append(sum);
            }
            s = next.toString();
        }

        return s.charAt(0) == s.charAt(1);
    }
    public static void main(String[] args) {
        System.out.println(hasSameDigits("3902"));
        System.out.println(hasSameDigits("34789"));
    }
}
