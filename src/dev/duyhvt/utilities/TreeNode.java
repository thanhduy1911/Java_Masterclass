package dev.duyhvt.utilities;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {
  public int val;
  public TreeNode left, right;

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  /**
   * Helper: build tree from level-order array where null means missing node. Example:
   * [1,2,3,null,4]
   */
  public static TreeNode buildLevelOrder(Integer[] arr) {
    if (arr == null || arr.length == 0 || arr[0] == null) return null;

    TreeNode root = new TreeNode(arr[0]);
    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    int i = 1;
    while (i < arr.length && !q.isEmpty()) {
      TreeNode cur = q.poll();
      if (cur == null) continue;

      if (arr[i] != null) {
        cur.left = new TreeNode(arr[i]);
        q.add(cur.left);
      }
      i++;

      if (i < arr.length && arr[i] != null) {
        cur.right = new TreeNode(arr[i]);
        q.add(cur.right);
      }
      i++;
    }
    return root;
  }
}
