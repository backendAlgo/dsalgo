package com.mprodev.easy;
/* Mirshod created on 2/21/2021 */

public class DecryptStringFromAlphabetToIntegerMapping {
    public String freqAlphabets(String s) {
        StringBuilder ans = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (i < len - 2 && s.charAt(i + 2) == '#') {
                ans.append(charFromNum(s.charAt(i), s.charAt(i + 1)));
                i += 2;
            } else {
                ans.append(charFromNum(s.charAt(i)));
            }
        }
        return ans.toString();
    }

    private char charFromNum(char c) {
        System.out.println((int) c);
        return (char) ((int) c - 1 + 'a' - '0');
    }

    private char charFromNum(char a, char b) {
        return (char) ((int) a * 10 + (int) b - 1 + 'a' - 11 * '0');
    }

    public static void main(String[] args) {
        System.out.println(
                new DecryptStringFromAlphabetToIntegerMapping().freqAlphabets("1326#")
        );
    }
}
