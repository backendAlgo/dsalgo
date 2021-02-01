package com.mprodev.easy;
/* Mirshod created on 1/31/2021 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PositionOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new LinkedList<>();
        if (s.length() == 0) return ans;
        char looking = s.charAt(0);
        int count = 0;
        int beginIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (looking == c) {
                count++;
                continue;
            }
            if (count >= 3) {
                ans.add(List.of(beginIndex, i - 1));
            }
            beginIndex = i;
            count = 1;
            looking = s.charAt(i);
        }
        if (count >= 3)
            ans.add(List.of(beginIndex, s.length() - 1));
        return ans;
    }
    //Leetcode solution more understandable but complexity the same
    public List<List<Integer>> largeGroupPositionsLeetcode(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, N = s.length();
        for (int j = 0; j < N; j++) {
            if (j == N-1 || s.charAt(j) != s.charAt(j+1)) {
                if (j - i >= 2) {
                    ans.add(List.of(i, j));
                }
                i = j + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new PositionOfLargeGroups().largeGroupPositionsLeetcode("abbxxxxzzyyy")
        );
    }
}
