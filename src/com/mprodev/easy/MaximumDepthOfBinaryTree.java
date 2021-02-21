package com.mprodev.easy;
/* Mirshod created on 2/10/2021 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    //iterative solution using bfs
    public int maxDepth(TreeNode root) {
        int ans = 0;
        //using bfs
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        TreeNode curr;
        while (!q.isEmpty()) {
            int size = q.size();
            ans++;
            for (int i = 0; i < size; i++) {
                curr = q.poll();
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
        }
        return ans;
    }
    //iterative using dfs
}
