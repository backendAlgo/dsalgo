package com.mprodev.easy;
/* Mirshod created on 2/6/2021 */

public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length==0) return m*n;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int[] a : ops) {
            minX = Math.min(minX, a[0]);
            minY = Math.min(minY, a[1]);
        }
        return minX*minY;
    }
}
