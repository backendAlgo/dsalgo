package com.mprodev.easy;
/* Mirshod created on 1/26/2021 */

import java.util.ArrayList;
import java.util.List;

public class TwoSumIVInputIsABST {
    private final List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        helper(root);
        int i = 0;
        int j = list.size() - 1;
        while(i<j) {
            int possible = list.get(i) + list.get(j);
            if (possible == k) return true;
            else if (possible < k) i++;
            else j--;
        }
        System.out.println(list);
        return false;
    }
    public void helper(TreeNode node) {
        if (node == null) return;
        helper(node.left);
        list.add(node.val);
        helper(node.right);
    }
}
