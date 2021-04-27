package com.mprodev.medium;
/* Mirshod created on 2/23/2021 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumErasureValue {
    // using prefix sum
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int lastIndex = 0;
        var map = new int[11111];
        Arrays.fill(map, -1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            lastIndex = Math.max(lastIndex, map[nums[i] + 1]);
            ans = Math.max(ans, prefixSum[i + 1] - prefixSum[lastIndex]);
            map[nums[i]] = i;
        }
        return ans;
    }
    // two pointers approach
    public int maximumUniqueSubarrayII(int[] nums) {
        int start = 0;
        int end = 0;
        int n = nums.length;
        int maxScore = Integer.MIN_VALUE;
        int curScore = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (end < n) {
            if (map.containsKey(nums[end])) {
                int id = map.get(nums[end]);

                while (start <= id) {
                    map.remove(nums[start]);
                    curScore -= nums[start];
                    start++;
                }
            }
            curScore += nums[end];
            map.put(nums[end], end);
            maxScore = Math.max(maxScore, curScore);
            end++;
        }
        return maxScore;
    }
}
