package dev.duyhvt.test.potd;

import dev.duyhvt.coding.potd._1161_Maximum_Level_Sum_of_a_Binary_Tree;
import dev.duyhvt.utilities.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _1161_Maximum_Level_Sum_of_a_Binary_Tree_Test {

  @Test
  void example1() {
    _1161_Maximum_Level_Sum_of_a_Binary_Tree sol = new _1161_Maximum_Level_Sum_of_a_Binary_Tree();

    // [1,7,0,7,-8,null,null]
    TreeNode root =
        new TreeNode(1, new TreeNode(7, new TreeNode(7), new TreeNode(-8)), new TreeNode(0));

    assertEquals(2, sol.maxLevelSum(root));
  }

  @Test
  void allNegative() {
    _1161_Maximum_Level_Sum_of_a_Binary_Tree sol = new _1161_Maximum_Level_Sum_of_a_Binary_Tree();

    //   -10
    //   /  \
    // -20  -30
    TreeNode root = new TreeNode(-10, new TreeNode(-20), new TreeNode(-30));

    // level1 sum=-10, level2 sum=-50 => max is level1
    assertEquals(1, sol.maxLevelSum(root));
  }

  @Test
  void tiePickSmallerLevel() {
    _1161_Maximum_Level_Sum_of_a_Binary_Tree sol = new _1161_Maximum_Level_Sum_of_a_Binary_Tree();

    // level1: 5
    // level2: 2 + 3 = 5 (tie)
    TreeNode root = new TreeNode(5, new TreeNode(2), new TreeNode(3));

    assertEquals(1, sol.maxLevelSum(root));
  }
}
