package com.mprodev.medium;
/* Mirshod created on 1/26/2021 */

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    //1. created copy for all nodes and
    // created one to one mapping with original and copy elements
    //2. using map created pointers to the next elements
    //
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> mp = new HashMap<>();
        mp.put(null, null);
        Node temp = head;
        while (temp != null) {
            mp.put(temp, createNode(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            mp.get(temp).next = mp.get(temp.next);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            mp.get(temp).random = mp.get(temp.random);
            temp = temp.next;
        }
        return mp.get(head);
    }

    public Node createNode(int val) {
        return new Node(val);
    }
}
