package dev.duyhvt.coding.potd;

import java.util.ArrayDeque;
import java.util.Deque;

public class _85_Maximal_Rectangle {

  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

    int m = matrix.length, n = matrix[0].length;
    int[] heights = new int[n];
    int ans = 0;

    for (char[] chars : matrix) {
      for (int col = 0; col < n; col++) {
        if (chars[col] == '1') {
          heights[col]++;
        } else {
          heights[col] = 0;
        }
      }
      ans = Math.max(ans, largestRectangleArea(heights));
    }

    return ans;
  }

  private int largestRectangleArea(int[] heights) {
    int n = heights.length;
    Deque<Integer> stack = new ArrayDeque<>();
    int best = 0;

    for (int i = 0; i <= n; i++) {
      int cur = (i == n) ? 0 : heights[i];

      while (!stack.isEmpty() && heights[stack.peek()] > cur) {
        int height = heights[stack.pop()];
        int leftLessIdx = stack.isEmpty() ? -1 : stack.peek();
        int width = i - leftLessIdx - 1;
        best = Math.max(best, height * width);
      }

      stack.push(i);
    }

    return best;
  }
}
