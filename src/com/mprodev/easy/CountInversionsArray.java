package com.mprodev.easy;
/* Mirshod created on 2/28/2021 */

import com.mprodev.algodsready.BIT;

public class CountInversionsArray {
//    using BIT or fedwick tree
    public static int getInvCount(int[] arr, int n) {
        int invCount = 0;
        // finding max element of the array
        int maxElement = -1;
        for (int i : arr) {
            maxElement = Math.max(maxElement, i);
        }

        // create BIT with size
        // equal to maxElement + 1
        BIT bit = new BIT(maxElement + 1);
        for (int i = 0; i < n; i++) {
            invCount += bit.query(arr[i] + 1, maxElement);
            bit.update(arr[i], 1);
        }

        return invCount;
    }
    public static void main(String[] args) {
        //int[] arr = {8,4,2,1};
        int [] arr = {7,6,2,3,1,4,5};
        int n = arr.length;
        System.out.println("Number of inversions are : " + getInvCount(arr, n));
    }
}
