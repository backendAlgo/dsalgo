package com.mprodev.medium;
/* Mirshod created on 2/24/2021 */

public class MinimumOperationsToReduceXToZero {
    //solution 1 using two pointers approach
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int curr = 0;
        while (l < n && curr < x) {
            curr += nums[l];
            l++;
        }
        int ans = Integer.MAX_VALUE;
        if (curr == x) ans = l;
        l--;
        while (l < r && l >= 0) {
            curr += nums[r];
            while (l >= 0 && curr - nums[l] >= x) {
                curr -= nums[l];
                l--;
            }
            if (curr == x) {
                ans = Math.min(ans, l + 1 + n - r);
            }
            r--;
        }
        if (ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }
    //solution 2 finding maxSubarray sum equal to sum - x
    //solution 3 dp

    public static void main(String[] args) {
        System.out.println(
                new MinimumOperationsToReduceXToZero().minOperations(
                        new int[]{1, 1, 4, 2, 3
                        }, 5
                )
        );
    }
}
