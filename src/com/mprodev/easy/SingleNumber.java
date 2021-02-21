package com.mprodev.easy;
/* Mirshod created on 2/10/2021 */

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums){
            ans ^= num;
        }
        return ans;
    }
}
