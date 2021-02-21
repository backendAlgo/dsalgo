package com.mprodev.medium;
/* Mirshod created on 2/18/2021 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    private List<String> maxNumOfParenthesis;

    public List<String> generateParenthesis(int n) {
        maxNumOfParenthesis = new LinkedList<>();
        solve("", 0, 0, n);
        return maxNumOfParenthesis;
    }

    private void solve(String curr, int open, int close, int max) {
        if (curr.length() == 2 * max)
            maxNumOfParenthesis.add(curr);
        if (open < max)
            solve(curr + "(", open + 1, close, max);
        if (open > close)
            solve(curr + ")", open, close + 1, max);
    }
}
