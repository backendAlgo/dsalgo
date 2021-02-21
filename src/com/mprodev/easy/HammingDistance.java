package com.mprodev.easy;
/* Mirshod created on 2/10/2021 */

import java.util.Arrays;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int diff = x ^ y;
        String diffStr = Integer.toBinaryString(diff);
        int ans = 0;
        for (char c : diffStr.toCharArray()) {
            if (c == '1') ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new HammingDistance().hammingDistance(1,4)
        );
    }
}
