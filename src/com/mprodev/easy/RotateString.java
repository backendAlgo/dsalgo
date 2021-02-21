package com.mprodev.easy;
/* Mirshod created on 1/29/2021 */

public class RotateString {
    /**
     * time complexity of KMP is O(n+m)
     * and in here n = m so
     * time complexity is O(n)
     */
    public boolean rotateStringUsingKMP(String A, String B) {
        if (A == null || B == null || A.length() != B.length()) return false;
        if (A.length() == 0) return true;
        A = A + A;
        int[] lps = prefixFunction(B);
        int aLen = A.length();
        int bLen = B.length();
        int i = 0; //index for A
        int j = 0; //index for B
        while (i < aLen) {
            if (A.charAt(i) == B.charAt(j)) {
                i++;
                j++;
            }
            if (j == bLen) {
                return true;
            } else if (i < aLen && B.charAt(j) != A.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return false;

    }

    //kmp prefix function
    public int[] prefixFunction(String a) {
        int n = a.length();
        int[] ans = new int[n];
        ans[0] = 0;
        for (int i = 1; i < n; i++) {
            int j = ans[i - 1];
            while (j > 0 && a.charAt(i) != a.charAt(j))
                j = ans[j - 1];
            if (a.charAt(i) == a.charAt(j))
                j++;
            ans[i] = j;
        }
        return ans;
    }

    /*
     *time complexity O(n*n)
     *  */
    public boolean rotataStringEasy(String A, String B) {
        if (A == null || B == null || A.length() != B.length()) return false;
        if (A.equals(B)) return true;
        StringBuilder builder = new StringBuilder(A);
        for (int i = 0; i < A.length() - 1; i++) {
            builder.deleteCharAt(0);
            builder.append(A.charAt(0));
            if (builder.toString().equals(B)) return true;
        }
        return false;
    }
}
