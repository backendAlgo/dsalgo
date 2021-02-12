package com.mprodev.medium;
/* Mirshod created on 2/7/2021 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LowestCommonAncestorOfABinaryTree {
    //recursive solution
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    public static void main(String[] args) {

    }
}
