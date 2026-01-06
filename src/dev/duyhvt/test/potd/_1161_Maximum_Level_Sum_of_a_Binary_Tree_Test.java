package dev.duyhvt.test.potd;

import dev.duyhvt.coding.potd._1161_Maximum_Level_Sum_of_a_Binary_Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _1161_Maximum_Level_Sum_of_a_Binary_Tree_Test {

  @Test
  void example1() {
    _1161_Maximum_Level_Sum_of_a_Binary_Tree sol = new _1161_Maximum_Level_Sum_of_a_Binary_Tree();

    // [1,7,0,7,-8,null,null]
    _1161_Maximum_Level_Sum_of_a_Binary_Tree.TreeNode root =
        new _1161_Maximum_Level_Sum_of_a_Binary_Tree.TreeNode(
            1,
            new _1161_Maximum_Level_Sum_of_a_Binary_Tree.TreeNode(
                7,
                new _1161_Maximum_Level_Sum_of_a_Binary_Tree.TreeNode(7),
                new _1161_Maximum_Level_Sum_of_a_Binary_Tree.TreeNode(-8)),
            new _1161_Maximum_Level_Sum_of_a_Binary_Tree.TreeNode(0));

    assertEquals(2, sol.maxLevelSum(root));
  }

  @Test
  void allNegative() {
    _1161_Maximum_Level_Sum_of_a_Binary_Tree sol = new _1161_Maximum_Level_Sum_of_a_Binary_Tree();

    //   -10
    //   /  \
    // -20  -30
    _1161_Maximum_Level_Sum_of_a_Binary_Tree.TreeNode root =
        new _1161_Maximum_Level_Sum_of_a_Binary_Tree.TreeNode(
            -10,
            new _1161_Maximum_Level_Sum_of_a_Binary_Tree.TreeNode(-20),
            new _1161_Maximum_Level_Sum_of_a_Binary_Tree.TreeNode(-30));

    // level1 sum=-10, level2 sum=-50 => max is level1
    assertEquals(1, sol.maxLevelSum(root));
  }

  @Test
  void tiePickSmallerLevel() {
    _1161_Maximum_Level_Sum_of_a_Binary_Tree sol = new _1161_Maximum_Level_Sum_of_a_Binary_Tree();

    // level1: 5
    // level2: 2 + 3 = 5 (tie)
    _1161_Maximum_Level_Sum_of_a_Binary_Tree.TreeNode root =
        new _1161_Maximum_Level_Sum_of_a_Binary_Tree.TreeNode(
            5,
            new _1161_Maximum_Level_Sum_of_a_Binary_Tree.TreeNode(2),
            new _1161_Maximum_Level_Sum_of_a_Binary_Tree.TreeNode(3));

    assertEquals(1, sol.maxLevelSum(root));
  }
}
