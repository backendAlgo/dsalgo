package com.mprodev.easy;
/* Mirshod created on 2/1/2021 */

import java.util.*;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new LinkedList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int count = 1;
        double average = 0;
        int num = 1;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            count--;
            average += curr.val;
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
            if (count == 0) {
                ans.add(average / num);
                count = num = q.size();
            }
        }
        return ans;
    }
    public List<Double> averageOfLevelsLeetcode(TreeNode root) {
        List<Double> ans = new LinkedList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int count = 1;
        double average = 0;
        while (!q.isEmpty()) {
            for (int i = 0; i < count; i++) {
                TreeNode curr = q.poll();
                average += curr.val;
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            ans.add(average / count);
            count = q.size();
            average = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
