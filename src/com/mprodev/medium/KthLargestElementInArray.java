package com.mprodev.medium;
/* Mirshod created on 2/14/2021 */

import java.util.Random;

public class KthLargestElementInArray {
    static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    static void random(int[] arr, int low, int high) {
        Random random = new Random();
        int pivot = random.nextInt(high-low+1) + low;
        swap(arr, pivot, high);
    }
    public int findKthLargest(int[] nums, int k) {
        return 5;
    }
    private int solve(int[] nums, int low, int high, int k) {
        random(nums, low, high);
        int pivot = nums[high];
        int i = low - 1;
        for (int j = 0; j < high; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, high);
        if (i + 1 < k)
            solve(nums, i + 2, high, k);
        return 0;
    }
}
