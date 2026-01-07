package dev.duyhvt.test.potd;

import dev.duyhvt.coding.potd._1339_Maximum_Product_of_Splitted_Binary_Tree;
import dev.duyhvt.utilities.TreeNode;
import org.junit.jupiter.api.Test;

import static dev.duyhvt.utilities.TreeNode.buildLevelOrder;
import static org.junit.jupiter.api.Assertions.*;

public class _1339_Maximum_Product_of_Splitted_Binary_Tree_Test {

  @Test
  void sample1() {
    // Example from LeetCode: [1,2,3,4,5,6]
    TreeNode root = buildLevelOrder(new Integer[] {1, 2, 3, 4, 5, 6});
    int ans = new _1339_Maximum_Product_of_Splitted_Binary_Tree().maxProduct(root);
    assertEquals(110, ans);
  }

  @Test
  void smallTree() {
    //   1
    //  / \
    // 2   3
    TreeNode root = buildLevelOrder(new Integer[] {1, 2, 3});
    int ans = new _1339_Maximum_Product_of_Splitted_Binary_Tree().maxProduct(root);
    assertEquals(9, ans);
  }

  @Test
  void singleNode() {
    TreeNode root = new TreeNode(5);
    int ans = new _1339_Maximum_Product_of_Splitted_Binary_Tree().maxProduct(root);
    // Cannot really split; product ends up 0
    assertEquals(0, ans);
  }
}
