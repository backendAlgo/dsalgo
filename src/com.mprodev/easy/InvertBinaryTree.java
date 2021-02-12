package com.mprodev.easy;
/* Mirshod created on 2/11/2021 */

import java.util.ArrayDeque;
import java.util.Queue;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int size = 1;
        TreeNode curr, temp;
        while (!q.isEmpty()) {
            for (int i = 0; i < size; i++) {
                curr = q.poll();
                temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            size = q.size();
        }
        return root;
    }
}
