package com.mprodev.easy;
/* Mirshod created on 2/11/2021 */

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        TreeNode curr;
        int size = 1;
        while (!q.isEmpty()) {
            List<Integer> row = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                curr = q.poll();
                row.add(curr.val);
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            ans.addFirst(row);
            size = q.size();
        }
        return ans;
    }
 }
