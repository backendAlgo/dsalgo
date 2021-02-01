package com.mprodev.easy;
/* Mirshod created on 1/27/2021 */

import java.util.Deque;
import java.util.LinkedList;

public class BaseballGame {
    public int calPoints(String[] ops) {
        Deque<Integer> scores = new LinkedList<>();
        for (String c : ops) {
            switch (c) {
                case "+":
                    int head = scores.pop();
                    int current = head + scores.getFirst();
                    scores.push(head);
                    scores.push(current);
                    break;
                case "D":
                    scores.addFirst(scores.getFirst() * 2);
                    break;
                case "C":
                    scores.removeFirst();
                    break;
                default:
                    scores.addFirst(Integer.valueOf(c));
                    break;
            }
        }
        int sum = 0;
        for (int i : scores) {
            sum += i;
        }
        return sum;
    }
}
