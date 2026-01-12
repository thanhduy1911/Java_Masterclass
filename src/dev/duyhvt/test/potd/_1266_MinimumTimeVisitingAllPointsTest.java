package dev.duyhvt.test.potd;

import dev.duyhvt.coding.potd._1266_MinimumTimeVisitingAllPoints;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _1266_MinimumTimeVisitingAllPointsTest {
  @Test
  void example1() {
    _1266_MinimumTimeVisitingAllPoints s = new _1266_MinimumTimeVisitingAllPoints();
    int[][] points = {{1, 1}, {3, 4}, {-1, 0}};
    assertEquals(7, s.minTimeToVisitAllPoints(points));
  }

  @Test
  void example2() {
    _1266_MinimumTimeVisitingAllPoints s = new _1266_MinimumTimeVisitingAllPoints();
    int[][] points = {{3, 2}, {-2, 2}};
    // dx=5, dy=0 => max=5
    assertEquals(5, s.minTimeToVisitAllPoints(points));
  }

  @Test
  void singlePoint() {
    _1266_MinimumTimeVisitingAllPoints s = new _1266_MinimumTimeVisitingAllPoints();
    int[][] points = {{0, 0}};
    assertEquals(0, s.minTimeToVisitAllPoints(points));
  }

  @Test
  void diagonalOnly() {
    _1266_MinimumTimeVisitingAllPoints s = new _1266_MinimumTimeVisitingAllPoints();
    int[][] points = {{0, 0}, {5, 5}};
    assertEquals(5, s.minTimeToVisitAllPoints(points));
  }

  @Test
  void mixedMoves() {
    _1266_MinimumTimeVisitingAllPoints s = new _1266_MinimumTimeVisitingAllPoints();
    int[][] points = {{0, 0}, {2, 5}};
    // dx=2 dy=5 -> 5
    assertEquals(5, s.minTimeToVisitAllPoints(points));
  }
}
