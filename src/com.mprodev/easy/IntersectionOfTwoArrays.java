package com.mprodev.easy;
/* Mirshod created on 1/24/2021 */

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> sets = new HashSet<>();
        Set<Integer> answer = new HashSet<>();
        for (int num : nums1) {
            sets.add(num);
        }
        for (int num : nums2) {
            if (sets.contains(num)) answer.add(num);
        }
        return answer.stream().mapToInt(e -> e).toArray();
    }

}
