package com.mprodev.algodsready;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Predicate;

public class InfixToPostfix {
    private static int operatorPrecedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
                return 3;
            case '(':
                return -1;
            default:
                throw new IllegalArgumentException("Operator not found");
        }
    }

    public static String infixToPostfix(String exp) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        Predicate<Character> isOperand = Character::isLetterOrDigit;
        for (char c : exp.toCharArray()) {
            if (isOperand.test(c)) {
                ans.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans.append(stack.poll());
                }
                stack.poll();
            } else {
                while (!stack.isEmpty() && operatorPrecedence(c) <= operatorPrecedence(stack.peek())) {
                    ans.append(stack.poll());
                }
                stack.push(c);
            }
//            System.out.print(ans);
//            System.out.println(" "+stack);
        }
        while (!stack.isEmpty())
            ans.append(stack.poll());
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
        System.out.println(infixToPostfix("A*(B+C)/D"));
    }
}
