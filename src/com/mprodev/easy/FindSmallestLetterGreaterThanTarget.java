package com.mprodev.easy;
/* Mirshod created on 1/29/2021 */

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        boolean atLeastOne = false;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (letters[mid] > target) {
                r = mid - 1;
                atLeastOne = true;
            } else {
                l = mid + 1;
            }
        }
        if (atLeastOne) return letters[l];
        else return letters[0];
    }
}
