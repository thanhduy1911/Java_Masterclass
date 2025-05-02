package dev.exercises.leetcode.daily.quiz_838_push_dominoes;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String dominoes1 = "RR.L";
        String dominoes2 = ".L.R...LR..L..";

        System.out.println(solution.pushDominoes(dominoes1));
        System.out.println(solution.pushDominoes(dominoes2));
    }
}
