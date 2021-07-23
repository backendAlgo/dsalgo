package com.mprodev.algodsready;

import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToExpressionTree {
    private static class Node {
        char data;
        Node left, right;

        Node(char data) {
            this.data = data;
            left = right = null;
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '/' || c == '*' || c == '^';
    }

    public static Node constructTree(String postfix) {
        Deque<Node> stack = new ArrayDeque<>();
        Node temp;
        for (char c : postfix.toCharArray()) {
            if (!isOperator(c)) {
                stack.push(new Node(c));
            } else {
                temp = new Node(c);
                temp.right = stack.poll();
                temp.left = stack.poll();
                stack.push(temp);
            }
        }
        return stack.poll();
    }

    public static String infixToPostfix(String infix) {
        return InfixToPostfix.infixToPostfix(infix);
    }

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

    public static void main(String[] args) {
        InfixToExpressionTree
                .inOrderTraversal(InfixToExpressionTree
                        .constructTree("ab+ef*g*-"));
    }
}


