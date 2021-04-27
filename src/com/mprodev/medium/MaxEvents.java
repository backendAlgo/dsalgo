package com.mprodev.medium;
/* Mirshod created on 3/1/2021 */

import java.util.Arrays;
import java.util.Comparator;

public class MaxEvents {
    // solution using segment tree
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        int n = 100005;
        SegTree segTree = new SegTree(0, n - 1);
        int ans = 0;
        for (int[] event : events) {
            int getMin = segTree.getMin(event[0], event[1]);
            if (event[0] <= getMin && getMin <= event[1]) {
                ans++;
                segTree.update(getMin);
            }
        }
        return ans;
    }

    static class SegTree {
        int leftMost, rightMost;
        SegTree leftChild, rightChild;
        int min;

        public SegTree(int leftMost, int rightMost) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) min = leftMost;
            else {
                int m = (rightMost + leftMost) / 2;
                leftChild = new SegTree(leftMost, m);
                rightChild = new SegTree(m + 1, rightMost);
                reCalc();
            }
        }

        private void reCalc() {
            if (leftMost == rightMost) return;
            this.min = Math.min(leftChild.min, rightChild.min);
        }

        public void update(int i) {
            if (leftMost == rightMost) {
                min = Integer.MAX_VALUE;
                return;
            }
            if (i <= leftChild.rightMost) leftChild.update(i);
            else rightChild.update(i);
            reCalc();
        }

        //        left right inclusive
        public int getMin(int l, int r) {
            if (l > rightMost || r < leftMost) return Integer.MAX_VALUE;
            if (l <= leftMost && r >= rightMost) return min;
            return Math.min(leftChild.getMin(l, r), rightChild.getMin(l, r));
        }
    }
}
