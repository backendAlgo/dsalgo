package com.mprodev.easy;
/* Mirshod created on 2/15/2021 */

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomChar = new int[26];
        for (char c : magazine.toCharArray()) {
            ransomChar[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            ransomChar[c - 'a']--;
            if (ransomChar[c-'a'] < 0)
                return false;
        }
        return true;
    }
}
