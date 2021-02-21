package com.mprodev.easy;
/* Mirshod created on 2/19/2021 */

import java.util.*;

public class NextGreaterElementI {
//    understand problem:
//    Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
//    hashmap = [1->3, 3->4] info about next greater element                                     |
//    Output: [-1,3,-1]
//    Input: nums1 = [2,4], nums2 = [1,2,3,4]
//                                     |
//    Output: [3,-1]
//    Approach using monotolic stack and hashmap
//
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> st = new ArrayDeque<>();
        for (int num : nums2) {
            while (!st.isEmpty() && st.peek() < num) {
                nextGreater.put(st.pop(), num);
            }
            st.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreater.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
