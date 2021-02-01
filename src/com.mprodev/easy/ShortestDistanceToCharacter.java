package com.mprodev.easy;
/* Mirshod created on 1/31/2021 */

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestDistanceToCharacter {
    public int[] shortestToChar(String S, char C) {
        int len = S.length();
        Queue<Integer> q = new ArrayDeque<>();
        int[] ans = new int[len];
        Integer lastIndex;
        Integer nextIndex;
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == C)
                q.offer(i);
        }
        lastIndex = q.poll();
        nextIndex = q.poll();
        if (nextIndex == null) {
            int j = 0;
            while (j < len) {
                ans[j] = Math.abs(j - lastIndex);
                j++;
            }
            return ans;
        }
        for (int i = 0; i < len; i++) {
            if (i > nextIndex) {
                lastIndex = nextIndex;
                nextIndex = q.poll();
            }
            if (nextIndex == null) {
                while (i < len) {
                    ans[i] = i - lastIndex;
                    i++;
                }

                break;
            }
            ans[i] = Math.min(Math.abs(i - lastIndex), nextIndex - i);

        }
        return ans;
    }
    // leetcode solution much easier but complexity the sam O(n)
    public int[] shortestToCharLeetcode(String S, char c) {
        return new int[4];
    }
}
