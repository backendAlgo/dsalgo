package com.mprodev.easy;
/* Mirshod created on 1/27/2021 */

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int one = Integer.highestOneBit(n);
        int num = 0;
        while (one != 0) {
            num += one;
            one = one >> 2;
        }
        Deque<String> str = new ArrayDeque<>();
        return n == num;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryNumberWithAlternatingBits().hasAlternatingBits(11));
    }
}
