package com.mprodev.medium;
/* Mirshod created on 2/3/2021 */

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0,-1);
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (k != 0)
                prefixSum %= k;
            if (m.containsKey(prefixSum)) {
                if (i - m.get(prefixSum) >= 2) return true;
            } else {
                m.put(prefixSum,i);
            }
        }
        return false;
    }
}
