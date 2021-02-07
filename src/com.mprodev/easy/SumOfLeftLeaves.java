package com.mprodev.easy;
/* Mirshod created on 2/6/2021 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SumOfLeftLeaves {
    int ans = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, false);
        return ans;
    }

    public void dfs(TreeNode node, Boolean possible) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            if (possible) ans += node.val;
            return;
        }
        dfs(node.left, true);
        dfs(node.right, false);
    }
//iterative solutions
    public int sumOfLeftLeavesIterative(TreeNode root) {
        Deque<TreeNode> st = new ArrayDeque<>();
        Map<TreeNode, Boolean> mp = new HashMap<>();
        TreeNode curr = root;
        mp.put(curr, false);
        int ans = 0;
        while (!st.isEmpty() || curr != null) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
                mp.put(curr, true);
            } else {
                curr = st.poll();
                if (curr.left == null && curr.right == null && mp.get(curr)) {
                    ans += curr.val;
                }
                curr = curr.right;
                mp.put(curr, false);
            }
        }
        return ans;
    }
}
