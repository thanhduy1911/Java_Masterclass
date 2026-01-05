package dev.duyhvt.test.potd;

import dev.duyhvt.coding.potd._1975_Maximum_Matrix_Sum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _1975_Maximum_Matrix_Sum_Test {

  @Test
  void testEvenNegative() {
    int[][] matrix = {
      {-1, 2},
      {3, -4}
    };
    assertEquals(10L, _1975_Maximum_Matrix_Sum.maxMatrixSum(matrix));
  }

  @Test
  void testOddNegative() {
    int[][] matrix = {
      {-1, 2},
      {3, 4}
    };
    assertEquals(8L, _1975_Maximum_Matrix_Sum.maxMatrixSum(matrix));
  }

  @Test
  void testContainsZero() {
    int[][] matrix = {
      {-1, 0},
      {2, 3}
    };
    // abs sum = 6, negCount=1 (odd), minAbs=0 => 6 - 0 = 6
    assertEquals(6L, _1975_Maximum_Matrix_Sum.maxMatrixSum(matrix));
  }

  @Test
  void testSingleCell() {
    int[][] matrix = {{-5}};
    // abs sum = 5, negCount=1, minAbs=5 => 5 - 10 = -5
    assertEquals(-5L, _1975_Maximum_Matrix_Sum.maxMatrixSum(matrix));
  }
}
