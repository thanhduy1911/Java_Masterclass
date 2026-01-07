package dev.duyhvt.coding.potd;

import dev.duyhvt.utilities.TreeNode;

import java.util.ArrayDeque;

public class _1161_Maximum_Level_Sum_of_a_Binary_Tree {
  public int maxLevelSum(TreeNode root) {
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    int level = 1, bestLevel = 1;
    long bestSum = Long.MIN_VALUE;

    while (!queue.isEmpty()) {
      int size = queue.size();
      long sum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        assert node != null;
        sum += node.val;

        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }

      if (sum > bestSum) {
        bestSum = sum;
        bestLevel = level;
      }
      level++;
    }

    return bestLevel;
  }
}
