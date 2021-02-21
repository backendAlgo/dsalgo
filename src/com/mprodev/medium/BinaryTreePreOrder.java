package com.mprodev.medium;
/* Mirshod created on 2/3/2021 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        TreeNode curr;
        while (!st.isEmpty()) {
            curr = st.poll();
            ans.add(curr.val);

            if (curr.right != null) st.push(curr.right);
            if (curr.left != null) st.push(curr.left);
        }
        return ans;
    }
}
