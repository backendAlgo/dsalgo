package com.mprodev.medium;
/* Mirshod created on 1/25/2021 */

public class CanJump {
    public boolean canJump(int[] nums) {
        int can_reach = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i <= can_reach) {
                can_reach = Math.max(can_reach, i + nums[i]);
            } else return false;
        }
        return true;
    }
}
