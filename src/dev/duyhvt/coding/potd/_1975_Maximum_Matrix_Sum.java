package dev.duyhvt.coding.potd;

public class _1975_Maximum_Matrix_Sum {
  public static void main(String[] args) {
    int[][] matrix = new int[][] {{1, -1}, {-1, 1}};
    int[][] matrix1 = new int[][] {{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}};

    System.out.println(maxMatrixSum(matrix));
    System.out.println(maxMatrixSum(matrix1));
  }

  public static long maxMatrixSum(int[][] matrix) {

    long sum = 0;
    long negCount = 0;
    long minAbs = Long.MAX_VALUE;

    for (int[] ints : matrix) {
      for (int val : ints) {
        if (val < 0) negCount++;

        long absVal = Math.abs((long) val);
        sum += absVal;

        if (absVal < minAbs) minAbs = absVal;
      }
    }

    return (negCount % 2 == 0) ? sum : sum - 2L * minAbs;
  }
}
