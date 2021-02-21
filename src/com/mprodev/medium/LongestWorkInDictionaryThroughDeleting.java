package com.mprodev.medium;
/* Mirshod created on 2/6/2021 */

import java.util.*;

public class LongestWorkInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        LinkedList<Integer>[] data = new LinkedList[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (data[c - 'a'] == null)
                data[c - 'a'] = new LinkedList<>();
            data[c - 'a'].add(i);
        }
        d.sort((e1, e2) -> {
            if (e1.length() > e2.length()) return -1;
            else if (e1.length() < e2.length()) return 1;
            else return e1.compareTo(e2);
        });
//        System.out.println(d);
//        System.out.println(Arrays.toString(data));
        for (String word : d) {
            if (possible(data, word)) return word;
        }
        return "";
    }

    private boolean possible(LinkedList<Integer>[] data, String word) {
        int currentIndex = -1;
        for (char c : word.toCharArray()) {
            if (data[c - 'a'] == null) return false;
            else {
                boolean found = false;
                for (int i : data[c - 'a']) {
                    if (i > currentIndex) {
                        currentIndex = i;
                        found = true;
                        break;
                    }
                }
                if (!found) return false;
            }
        }
        return true;
    }
    //another way suggested by leetcode no need of hashmap
    private boolean isPossible(String s, String word) {
        int j = 0;
        for (int i = 0; i < s.length() && j < word.length(); i++) {
            if (s.charAt(i) == word.charAt(j)) {
                j++;
            }
        }
        return j == word.length();
    }
    public String findLongestWordLeetcode(String s, List<String> d) {
        String ans = "";
        for (String word : d) {
            if (isPossible(s, word)) {
                if (ans.length() == word.length()) {
                    if (ans.length() == 0 || ans.compareTo(word) > 0)
                        ans = word;
                } else if (ans.length() < word.length())
                    ans = word;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("ale".compareTo("apple"));
                System.out.println(
                new LongestWorkInDictionaryThroughDeleting().findLongestWordLeetcode(
                        "abpcplea",
                        new LinkedList<>(List.of("ale","apple","monkey","plea"))
                )
        );
    }
}
