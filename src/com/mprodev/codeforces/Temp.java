package com.mprodev.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * mprodev for codeforces
 */

public class Temp {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int T = fs.nextInt();
        int[] arr = fs.readArray(n);
        SegmentTreeErrichto segmentTreeErrichto = new SegmentTreeErrichto(arr);
        for (int tt = 0; tt < T; tt++) {
            int type = fs.nextInt();
            if (type == 1) {
                int index = fs.nextInt() - 1;
                int value = fs.nextInt();
                segmentTreeErrichto.update(index, value);
            } else {
                int l = fs.nextInt() - 1;
                int r = fs.nextInt() - 1;
                System.out.println(
                        segmentTreeErrichto
                                .sumRange(1,
                                        0, segmentTreeErrichto.n - 1,
                                        l, r));
            }
        }

    }

    static class SegmentTreeErrichto {
        private final int[] tree;
        private final int n;

        public SegmentTreeErrichto(int[] arr) {
            int n = arr.length;
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

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }


}
