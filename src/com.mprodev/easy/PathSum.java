package com.mprodev.easy;
/* Mirshod created on 2/12/2021 */

import java.util.ArrayDeque;
import java.util.Deque;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root, targetSum, 0);
    }
    private boolean dfs(TreeNode node, int targetSum, int pathSum) {
        pathSum += node.val;
        if (node.left == null && node.right == null) {
            return targetSum == pathSum;
        }
        boolean left = false;
        boolean right = false;
        if (node.left != null)
            left = dfs(node.left, targetSum, pathSum);
        if (node.right != null)
            right = dfs(node.right, targetSum, pathSum);
        return left || right;
    }
}
