package com.mprodev.easy;
/* Mirshod created on 1/28/2021 */

import java.util.Arrays;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        if (len == 0) return -1;
        int[] suffix = new int[len+1];
        suffix[len] = 0;
        suffix[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            suffix[i] = nums[i] + suffix[i+1];
        }
        int prefix = 0;
        for (int i = 0; i < len; i++) {
            if (prefix == suffix[i+1]) return i;
            prefix += nums[i];
        }
        return -1;
    }
}
