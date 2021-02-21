package com.mprodev.medium;
/* Mirshod created on 1/25/2021 */

import java.util.LinkedList;
import java.util.Queue;

public class FindTheLeftMostElement {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 1;
        int ans = root.val;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            count--;
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
            if (count == 0 && !q.isEmpty()) {
                ans = q.peek().val;
                count = q.size();
            }
        }
        return ans;
    }
    //recursive solution
    private int answer;
    private int count = 0;
    public int findBottomLeftValueRecursive(TreeNode root) {
        helper(root, 0);
        return answer;
    }
    public void helper(TreeNode e, int level) {
        if (e == null) return;
        if (count == level) {
            answer = e.val;
            count++;
        }

        helper(e.left, level+1);
        helper(e.right, level+1);
    }
}
