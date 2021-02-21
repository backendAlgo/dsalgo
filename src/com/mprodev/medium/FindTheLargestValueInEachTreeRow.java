package com.mprodev.medium;
/* Mirshod created on 1/24/2021 */


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindTheLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        int rowCount = 1;
        int i = 0;
        int rowMax = root.val;
        int nextRowCount = 0;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            i++;
            rowMax = Math.max(rowMax, curr.val);
            if (curr.left != null) {
                q.add(curr.left);
                nextRowCount++;
            }
            if (curr.right != null) {
                q.add(curr.right);
                nextRowCount++;
            }

            if (rowCount == i) {
                i = 0;
                rowCount = nextRowCount;
                nextRowCount = 0;
                ans.add(rowMax);
                rowMax = Integer.MIN_VALUE;
            }
        }
        return ans;
    }
}
