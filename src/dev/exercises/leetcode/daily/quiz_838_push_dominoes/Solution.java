package dev.exercises.leetcode.daily.quiz_838_push_dominoes;

public class Solution {
    public String pushDominoes(String dominoes) {
        dominoes = "L" + dominoes + "R";
        StringBuilder result = new StringBuilder();
        int prev = 0;
        for (int curr = 1; curr < dominoes.length(); ++curr) {
            if (dominoes.charAt(curr) == '.') continue;

            int span = curr - prev - 1;
            if (prev > 0) {
                result.append(dominoes.charAt(prev));
            }

            if (dominoes.charAt(prev) == dominoes.charAt(curr)) {
                for (int i = 0; i < span; ++i) {
                    result.append(dominoes.charAt(prev));
                }
            } else if (dominoes.charAt(prev) == 'L' && dominoes.charAt(curr) == 'R') {
                for (int i = 0; i < span; ++i) {
                    result.append('.');
                }
            } else {
                for (int i = 0; i < span / 2; ++i) {
                    result.append('R');
                }
                if (span % 2 == 1) {
                    result.append('.');
                }
                for (int i = 0; i < span / 2; ++i) {
                    result.append('L');
                }
            }
            prev = curr;
        }
        return result.toString();
    }
}
