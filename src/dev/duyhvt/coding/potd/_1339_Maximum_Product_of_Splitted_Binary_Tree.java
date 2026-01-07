package dev.duyhvt.coding.potd;

import dev.duyhvt.utilities.TreeNode;

public class _1339_Maximum_Product_of_Splitted_Binary_Tree {
  private static final long MOD = 1_000_000_007L;
  private long totalSum;
  private long maxSum;

  public int maxProduct(TreeNode root) {
    totalSum = sum(root);
    maxSum = 0;
    sumAndUpdate(root);

    return (int) (maxSum % MOD);
  }

  private long sum(TreeNode node) {
    if (node == null) return 0;
    return node.val + sum(node.left) + sum(node.right);
  }

  private long sumAndUpdate(TreeNode node) {
    if (node == null) return 0;

    long left = sumAndUpdate(node.left);
    long right = sumAndUpdate(node.right);
    long sub = node.val + left + right;

    maxSum = Math.max(maxSum, sub * (totalSum - sub));

    return sub;
  }
}
