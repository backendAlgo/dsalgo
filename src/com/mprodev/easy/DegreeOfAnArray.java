package com.mprodev.easy;
/* Mirshod created on 1/28/2021 */

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
    class Info {
        int begInd;
        int len;
        int count;

        Info(int begInd) {
            this.begInd = begInd;
            len = 1;
            count = 1;
        }
    }

    public int findShortestSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Info> map = new HashMap<>();
        int maxCount = 0;
        int maxLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            Info currInfo = map.get(curr);
            if (currInfo != null) {
                currInfo.count++;
                currInfo.len = i - currInfo.begInd + 1;
            } else {
                currInfo = new Info(i);
                map.put(curr, currInfo);
            }
            if (maxCount < currInfo.count ||
                    (maxCount == currInfo.count) && (maxLen > currInfo.len)
            ) {
                maxCount = currInfo.count;
                maxLen = currInfo.len;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(
                new DegreeOfAnArray()
                        .findShortestSubArray(
                                new int[]{1}
                        )
        );
    }
}
