package dev.duyhvt.coding.array;

import java.util.Arrays;

public class HeightChecker {
    public static int heightChecker(int[] heights) {
        int[] excepted = Arrays.copyOf(heights, heights.length);
        Arrays.sort(excepted);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != excepted[i]) {
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println(heightChecker(new int [] { 1,1,4,2,1,3 }));
    }
}
