package com.mprodev.medium;

/* Mirshod created on 1/29/2021 */
public class PopulatingNextRightPointersInEachNodeII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        helper(root);
        return root;
    }

    public void helper(Node root) {
        if (root == null) return;
        Node i = root;
        Node last = null;
        Node next = null;
        while (i != null) {
            if (i.left != null) {
                if (last == null) {
                    next = i.left;
                    last = next;
                } else {
                    last.next = i.left;
                    last = i.left;
                }
            }
            if (i.right != null) {
                if (last == null) {
                    next = i.right;
                    last = next;
                } else {
                    last.next = i.right;
                    last = i.right;
                }
            }
            i = i.next;
        }
        helper(next);
    }
}
