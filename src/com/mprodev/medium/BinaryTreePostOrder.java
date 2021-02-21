package com.mprodev.medium;
/* Mirshod created on 1/26/2021 */


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostOrder {
    private final List<Integer> answer = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        helper(root);
        return answer;
    }
    public void helper(TreeNode n) {
        if (n == null) return;
        helper(n.left);
        helper(n.right);
        answer.add(n.val);
    }
    //iterative solution
    public List<Integer> postorderTraversalIterative(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            ans.addFirst(curr.val);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }
        return ans;
    }
}
