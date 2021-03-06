package com.mprodev.algodsready;
/* Mirshod created on 2/10/2021 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class PostOrderIterative {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right;
        }
    }

    public static void postOrderTraversal(Node node)

    {
        Node root;
        ArrayList<Integer> list = new ArrayList<Integer>();

        // An iterative function to do postorder traversal
        // of a given binary tree
        Deque<Node> S = new ArrayDeque<>();

        // Check for empty tree
        if (node == null)
            return;
        S.push(node);
        Node prev = null;
        while (!S.isEmpty()) {
            Node current = S.peek();

            /* go down the tree in search of a leaf an if so process it
            and pop stack otherwise move down */
            if (prev == null || prev.left == current ||
                    prev.right == current) {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else {
                    S.pop();
                    list.add(current.data);
                }

                /* go up the tree from left node, if the child is right
                push it onto stack otherwise process parent and pop
                stack */
            } else if (current.left == prev) {
                if (current.right != null)
                    S.push(current.right);
                else {
                    S.pop();
                    list.add(current.data);
                }

                /* go up the tree from right node and after coming back
                from right node process parent and pop stack */
            } else if (current.right == prev) {
                S.pop();
                list.add(current.data);
            }

            prev = current;
        }
    }
}
