package com.mprodev.medium;
/* Mirshod created on 2/22/2021 */

import java.util.HashSet;
import java.util.Set;
//practise two pointers technique
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> bucket = new HashSet<>();
        int p1 = 0, p2 = 0;
        int ans = 0;
        for (p1 = 0; p1 < s.length() && p2 < s.length(); p1++) {
            while (p2 < s.length() && !bucket.contains(s.charAt(p2))) {
                bucket.add(s.charAt(p2));
                ans = Math.max(ans, bucket.size());
                p2++;
            }
            bucket.remove(s.charAt(p1));
        }
        return ans;
    }
}
