package com.mprodev.easy;
/* Mirshod created on 2/2/2021 */

import java.util.*;

public class LeafSimilarTrees {
    //recursion
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) return false;
        }
        return true;
    }

    public void dfs(TreeNode root, List<Integer> store) {
        if (root == null) return;
        if (root.left != null) dfs(root.left, store);
        if (root.right != null) dfs(root.right, store);
        if (root.right == null && root.left == null) store.add(root.val);
    }

    //iterative solution time complexity the same as above
    public boolean leafSimilarIterative(TreeNode root1, TreeNode root2) {
        List<Integer> leaves = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode curr = root1;
        while (!st.isEmpty() || curr != null) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                curr = st.poll();
                if (curr.left == null && curr.right == null) {
                    leaves.add(curr.val);
                }
                curr = curr.right;
            }
        }
        System.out.println(leaves);
        int i = 0;
        curr = root2;
        while (!st.isEmpty() || curr != null) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                curr = st.poll();
                if (curr.left == null && curr.right == null) {
                    System.out.println(curr.val);
                    if (i == leaves.size() || leaves.get(i++) != curr.val) return false;
                }
                curr = curr.right;
            }
        }
        return i == leaves.size();
    }

}
