package com.mprodev.medium;
/* Mirshod created on 2/10/2021 */

import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    private List<List<Integer>> ans = new LinkedList<>();;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return ans;
        LinkedList<Integer> store = new LinkedList<>();
        dfs(root, store, targetSum, 0);
        return ans;
    }
    private void dfs(TreeNode node, LinkedList<Integer> store, int targetSum, int currentSum) {
        store.addLast(node.val);
        currentSum += node.val;
        if (node.left != null) dfs(node.left, store, targetSum, currentSum);
        if (node.right != null) dfs(node.right, store, targetSum, currentSum);
        if (node.right == null &&  node.left == null) {
            if (targetSum == currentSum) ans.add(new LinkedList<>(store));
        }
        store.removeLast();
    }
}
