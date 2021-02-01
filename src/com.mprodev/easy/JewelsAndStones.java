package com.mprodev.easy;
/* Mirshod created on 2/1/2021 */

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> setOfJewels = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            setOfJewels.add(c);
        }
        int ans = 0;
        for (char c : stones.toCharArray()) {
            if (setOfJewels.contains(c))
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new JewelsAndStones().numJewelsInStones("aA", "aAAbbbb")
        );
    }
}
