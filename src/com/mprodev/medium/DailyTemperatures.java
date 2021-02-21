package com.mprodev.medium;
/* Mirshod created on 2/19/2021 */

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        var ans = new int[T.length];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < T.length; i++) {
            int curr = T[i];
            while (!st.isEmpty() && T[st.peek()] < curr) {
                ans[st.peek()] = i - st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}
