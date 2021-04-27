package com.mprodev.medium;
/* Mirshod created on 2/28/2021 */

import com.mprodev.algodsready.BIT;

public class NumArray {
    // using BIT or Fedwick tree
    int[] bit;
    int[] nums;
    int n;

    public NumArray(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        bit = new int[n + 1];
        this.n = n;
        for (int i = 0; i < n; i++) {
            init(i, nums[i]);
        }
    }

    public void init(int i, int diff) {
        for (i++; i <= n; i += i & -i) {
            bit[i] += diff;
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }

    public int read(int i) {
        int sum = 0;
        for (i++; i > 0; i -= i & -i) {
            sum += bit[i];
        }
        return sum;
    }

    public int sumRange(int left, int right) {
        return read(right) - read(left - 1);
    }

    static class NumArraySegmentTree {
        private int[] tree;

        public NumArraySegmentTree(int[] nums) {
            int n = nums.length;
            tree = new int[4 * n];
            build(nums, 1, 0, n-1);
        }

        public void build(int[] arr, int i, int l, int r) {
            if (l == r) {
                tree[i] = arr[l];
            } else {
                int m = l + (r - l) / 2;
                build(arr, i * 2, l, m);
                build(arr, i * 2 + 1, m + 1, r);
                tree[i] = tree[i * 2] + tree[i * 2 + 1];
            }
        }

        public void update(int index, int val) {

        }

        public int sumRange(int left, int right) {
            return 0;
        }
    }
}
