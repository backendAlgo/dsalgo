package com.mprodev.algodsready;

import java.util.Arrays;
import java.util.Random;

/* Mirshod created on 2/28/2021 */
public class SegmentTree {
    public static void main(String[] args) {
        Random random = new Random(5);
        int T = 100;
        for (int tt = 0; tt < T; tt++) {
            // make random array
            int n = 1 + random.nextInt(10);
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = random.nextInt(10);
            SegTree st = new SegTree(0, n - 1, a);
            SegTreeArr sarr = new SegTreeArr(a);
            SegTreeBottomUp segTreeBottomUp = new SegTreeBottomUp(a);
            SegmentTreeErrichto segmentTreeErrichto = new SegmentTreeErrichto(n, a);
            SQRTDecomposition sqrtDecomposition = new SQRTDecomposition(a);
            // answer bunch of queries

            int nQueries = 100;
            for (int qq = 0; qq < nQueries; qq++) {
                if (random.nextBoolean()) {
                    // range sum query
                    int l = random.nextInt(n);
                    int r = random.nextInt(n);
                    int ans = 0;
                    for (int i = l; i <= r; i++) ans += a[i];
                    int stAns = st.rangeSum(l, r);
                    int stArrAns = sarr.rangeSum(1, 0, n - 1, l, r);
                    int stBottomUp = segTreeBottomUp.sumRange(l, r);
                    int stErrichto = segmentTreeErrichto.sumRange(1, 0, segmentTreeErrichto.n - 1, l, r);
                    int sqrtAns = sqrtDecomposition.sumRange(l, r);
                    if (stAns != ans) throw new RuntimeException("Segment tree is wrong");
                    if (stAns != stArrAns) throw new RuntimeException("Segment Array Tree is wrong");
                    if (stAns != stBottomUp) throw new RuntimeException("Segment Tree Bottom up wrong");
                    if (stAns != stErrichto) throw new RuntimeException("Segment Tree Errichto wrong");
                } else {
                    // point update array
                    int index = random.nextInt(n);
                    int newValue = random.nextInt(10);
                    a[index] = newValue;
                    st.pointUpdate(index, newValue);
                    sarr.update(1, 0, n - 1, index, newValue);
                    segTreeBottomUp.update(index, newValue);
                    segmentTreeErrichto.update(index, newValue);
                    sqrtDecomposition.update(index, newValue);
                }
            }
        }
        System.out.println("All tests passed");
    }

    //segment tree using array
    static class SegTreeArr {
        int n;
        int[] tree;

        public SegTreeArr(int[] a) {
            this.n = a.length;
            this.tree = new int[4 * n];
            build(a, 1, 0, n - 1);
        }

        public void build(int[] a, int v, int tl, int tr) {
            if (tl == tr) tree[v] = a[tr];
            else {
                int tm = tl + (tr - tl) / 2;
                //left child
                build(a, v * 2, tl, tm);
                //right child
                build(a, v * 2 + 1, tm + 1, tr);
                tree[v] = tree[v * 2] + tree[v * 2 + 1];
            }
        }

        public int rangeSum(int v, int tl, int tr, int l, int r) {
            if (l > r) return 0;
            if (l == tl && r == tr) return tree[v];
            int tm = tl + (tr - tl) / 2;
            return rangeSum(v * 2, tl, tm, l, Math.min(tm, r))
                    + rangeSum(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r);
        }

        public void update(int v, int tl, int tr, int pos, int newVal) {
            if (tl == tr) tree[v] = newVal;
            else {
                int tm = tl + (tr - tl) / 2;
                if (pos <= tm)
                    update(v * 2, tl, tm, pos, newVal);
                else
                    update(v * 2 + 1, tm + 1, tr, pos, newVal);
                tree[v] = tree[2 * v] + tree[2 * v + 1];
            }
        }
    }

    //segment tree using object
    static class SegTree {
        int leftMost, rightMost;
        SegTree lChild, rChild;
        int sum;

        public SegTree(int leftMost, int rightMost, int[] a) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                // leaf
                sum = a[leftMost];
            } else {
                // have children
                int m = leftMost + (rightMost - leftMost) / 2;
                lChild = new SegTree(leftMost, m, a);
                rChild = new SegTree(m + 1, rightMost, a);
                reCalc();
            }
        }

        public void reCalc() {
            if (leftMost == rightMost) return;
            sum = lChild.sum + rChild.sum;
        }

        public void pointUpdate(int i, int newValue) {
            if (leftMost == rightMost) {
                sum = newValue;
                return;
            }
            if (i <= lChild.rightMost) lChild.pointUpdate(i, newValue);
            else rChild.pointUpdate(i, newValue);
            reCalc();
        }

        // [l,r] inclusive
        public int rangeSum(int l, int r) {
            // entirely disjoint
            if (l > rightMost || r < leftMost) return 0;
            // covers us
            if (l <= leftMost && r >= rightMost) return sum;

            //case 3: we don't know
            return lChild.rangeSum(l, r) + rChild.rangeSum(l, r);
        }
    }

    //segment tree using bottom up approach with 2*n space
    static class SegTreeBottomUp {
        private int[] tree;
        int n;

        public SegTreeBottomUp(int[] arr) {
            int n = arr.length;
            if (n > 0) {
                this.tree = new int[2 * n];
                this.n = n;
                build(arr);
            }
        }

        private void build(int[] arr) {
            for (int i = n, j = 0; i < 2 * n; i++, j++)
                tree[i] = arr[j];
            for (int i = n - 1; i > 0; i--)
                tree[i] = tree[2 * i] + tree[2 * i + 1];
        }

        public void update(int i, int val) {
            i += n;
            tree[i] = val;
            while (i > 0) {
                int l = i;
                int r = i;
                if (i % 2 == 0) {
                    r = i + 1;
                } else {
                    l = i - 1;
                }
                // parent is updated after children updated
                tree[i / 2] = tree[l] + tree[r];
                i /= 2;
            }
        }

        public int sumRange(int l, int r) {
            // get leaf with value 'l'
            l += n;
            // get leaf with value 'r'
            r += n;
            int sum = 0;
            while (l <= r) {
                if ((l % 2) == 1) {
                    sum += tree[l];
                    l++;
                }
                if ((r % 2) == 0) {
                    sum += tree[r];
                    r--;
                }
                l /= 2;
                r /= 2;
            }
            return sum;
        }
    }

    static class SegmentTreeErrichto {
        private final int[] tree;
        private final int n;

        public SegmentTreeErrichto(int n, int[] arr) {
            while (Integer.bitCount(n) != 1) {
                n++;
            }
            tree = new int[2 * n];
            this.n = n;
            buildTree(arr);
        }

        public void buildTree(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                tree[n + i] = arr[i];
            }
            for (int i = n - 1; i > 0; i--) {
                tree[i] = tree[2 * i] + tree[2 * i + 1];
            }
        }

        public int sumRange(int node, int nodeLow, int nodeHigh, int queryLow, int queryHigh) {
            if (queryLow <= nodeLow && nodeHigh <= queryHigh)
                return tree[node];
            if (nodeHigh < queryLow || nodeLow > queryHigh)
                return 0;
            int lastInLeft = (nodeLow + nodeHigh) / 2;
            return sumRange(2 * node, nodeLow, lastInLeft, queryLow, queryHigh) +
                    sumRange(2 * node + 1, lastInLeft + 1, nodeHigh, queryLow, queryHigh);
        }

        public void update(int i, int v) {
            tree[n + i] = v;
            for (int j = (n + i) / 2; j >= 1; j /= 2) {
                tree[j] = tree[2 * j] + tree[2 * j + 1];
            }
        }
    }
}
