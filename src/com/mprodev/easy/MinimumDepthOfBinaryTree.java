package com.mprodev.easy;
/* Mirshod created on 2/10/2021 */

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumDepthOfBinaryTree {
    //recursive solution
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int depth) {
        depth++;
        //checking if this node is leaf or not
        if (node.right == null && node.left == null) {
            return depth;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (node.left != null) left = dfs(node.left, depth);
        if (node.right != null) right = dfs(node.right, depth);
        return Math.min(left, right);
    }
}
