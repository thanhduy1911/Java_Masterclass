package dev.duyhvt.coding.array;

import java.util.Arrays;

public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int leftTotal = 0;

        for (int i = 0; i < nums.length; i++) {
            int rightTotal = total - leftTotal - nums[i];
            if (rightTotal == leftTotal) {
                return i;
            }

            leftTotal += nums[i];
        }

        return -1;
    }
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int [] { 1,7,3,6,5,6 }));
    }
}
