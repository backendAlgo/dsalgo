package com.mprodev.easy;
/* Mirshod created on 1/29/2021 */

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        int minVal = Integer.MAX_VALUE;
        int lastVal = 0;
        boolean firstTime = true;
        while(root != null || stack.size() > 0) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.poll();
                //
                if (!firstTime) {
                    minVal = Math.min(root.val - lastVal, minVal);
                } else
                    firstTime = false;
                lastVal = root.val;
                //
                root = root.right;
            }
        }
        return minVal;
    }
}
