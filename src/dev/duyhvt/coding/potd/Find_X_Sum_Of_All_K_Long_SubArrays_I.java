package dev.duyhvt.coding.potd;

import java.util.*;

public class Find_X_Sum_Of_All_K_Long_SubArrays_I {
    public static int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i <= n - k; ++i) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int j = i; j < i + k; ++j) {
                cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
            }

            List<int[]> freq = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                freq.add(new int[] {entry.getValue(), entry.getKey() });
            }

            freq.sort((a, b) -> b[0] != a[0] ? b[0] - a[0] : b[1] - a[1]);
            int curSum = 0;
            for (int j = 0; j < x && j < freq.size(); ++j) {
                curSum += freq.get(j)[0] * freq.get(j)[1];
            }

            res[i] = curSum;
        }

        return res;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findXSum(new int[]{1,1,2,2,3,4,2,3}, 6, 2)));
        System.out.println(Arrays.toString(findXSum(new int[]{3,8,7,8,7,5}, 2, 2)));
    }
}
