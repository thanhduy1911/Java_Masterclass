package dev.duyhvt.coding.array;

import java.util.Arrays;

public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] nums) {
        if (nums.length == 1) return nums;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Array before sorting: " + Arrays.toString(nums));
            if (nums[i] % 2 == 0) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
            System.out.println("Array after sorting: " + Arrays.toString(nums));
        }

        return nums;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3,1,2,4})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{0})));
    }
}
