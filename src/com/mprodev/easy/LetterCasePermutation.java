package com.mprodev.easy;
/* Mirshod created on 1/30/2021 */

import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new LinkedList<>();
        helper(new StringBuilder(S), 0, ans);
        return ans;
    }

    public void helper(StringBuilder S, int index, List<String> ans) {
        if (index >= S.length()) {
            ans.add(S.toString());
            return;
        }

        char c = S.charAt(index);
        if (Character.isLetter(c)) {
            helper(S.replace(
                    index, index + 1, String.valueOf(Character.toLowerCase(c))
                    ),
                    index + 1, ans);
            helper(S.replace(index, index + 1, String.valueOf(Character.toUpperCase(c))
                    ),
                    index + 1, ans);
        } else {
            helper(
                    S, index + 1, ans);
        }
    }
}
