package dev.duyhvt.coding.potd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheTwoSneakyNumbersOfDigitVille {
    private static int[] solution(int[] nums) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int num : nums) {
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = seen.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        return result.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args) {

    }
}
