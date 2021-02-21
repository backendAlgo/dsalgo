package com.mprodev.medium;

/* Mirshod created on 1/29/2021 */
public class PopulatingNextRightPointersInEachNode {
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
        Node i = root;
        while (i != null && i.left != null) {
            helper(i);
            i = i.left;
        }
        return root;
    }
    public void helper(Node curr) {
        Node temp = curr;
        while (temp != null) {
            temp.left.next = temp.right;
            if (temp.next != null)
                temp.right.next = temp.next.left;
            temp = temp.next;
        }
    }
}
