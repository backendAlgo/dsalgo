package com.mprodev.easy;
/* Mirshod created on 1/24/2021 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.merge(i, 1, Integer::sum);
        }
        for (int i : nums2) {
            Integer val;
            if (((val = map.get(i)) != null) && val != 0) {
                ans.add(i);
                map.put(i, --val);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
