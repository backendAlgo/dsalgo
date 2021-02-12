package com.mprodev.easy;
/* Mirshod created on 2/10/2021 */

public class DeleteNodeInALinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
