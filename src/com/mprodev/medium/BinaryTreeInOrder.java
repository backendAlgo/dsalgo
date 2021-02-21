package com.mprodev.medium;
/* Mirshod created on 2/1/2021 */

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTreeInOrder {
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    //iterative
    public static void inOrderTraversal(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        Node curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
        }
    }
}
