package dev.duyhvt.coding;

public class MinimumTimeToMakeRopeColorful {
    public static int minCost(String colors, int[] neededTime) {
        int res = 0, l = 0;
        for (int r = 1; r < colors.length(); r++) {
            if (colors.charAt(l) == colors.charAt(r)) {
                if (neededTime[l] < neededTime[r]) {
                    res += neededTime[l];
                    l = r;
                } else {
                    res += neededTime[r];
                }
            } else {
                l = r;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minCost("abaac", new int[]{1, 2, 3,4,5}));
        System.out.println(minCost("abc", new int[]{1, 2, 3}));
        System.out.println(minCost("aabaa", new int[]{1,2,3,4,1}));
    }
}
