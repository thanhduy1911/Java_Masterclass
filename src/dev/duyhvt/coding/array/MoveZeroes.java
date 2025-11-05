package dev.duyhvt.coding.array;

import java.util.Arrays;

public class MoveZeroes {
    // Two Pointers
    public static void moveZeroesWithTwoPointers(int[] nums) {
        if (nums.length == 1 && nums[0] == 0) {
            return;
        }
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
    // Snow Ball
    public static void moveZeroes(int[] nums) {
        int snowBallSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowBallSize++;
            } else if (snowBallSize > 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[i - snowBallSize] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        int[] nums1 = {0, 2, 0, 0, 0, 3, 1, 5, 2, 623};
        moveZeroesWithTwoPointers(nums);
        moveZeroes(nums1);
        System.out.println("Using two pointers: " + Arrays.toString(nums));
        System.out.println("Using snow ball: " + Arrays.toString(nums1));
    }
}
