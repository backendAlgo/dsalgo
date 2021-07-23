package com.mprodev.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * mprodev for codeforces
 */

public class atcodeD {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int h = fs.nextInt(), w = fs.nextInt();
        long c = fs.nextLong();
        int[][] a = new int[h][w];
        for (int i = 0; i < h; i++) {
            a[i] = fs.readArray(w);
        }
        long[][] dp = new long[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                dp[i][j] = tripleMin(a[i][j],
                        i != 0 ? dp[i - 1][j] + c : Long.MAX_VALUE,
                        j != 0 ? dp[i][j - 1] + c : Long.MAX_VALUE);
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = w - 1; j >= 0; j--) {
                dp[i][j] = tripleMin(dp[i][j],
                        i != h - 1 ? dp[i + 1][j] + c : Long.MAX_VALUE,
                        j != w - 1 ? dp[i][j + 1] + c : Long.MAX_VALUE);
            }
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                ans = tripleMin(ans, i != 0 ? dp[i - 1][j] + c + a[i][j] : Long.MAX_VALUE,
                        j != 0 ? dp[i][j - 1] + c + a[i][j] : Long.MAX_VALUE);
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                ans = tripleMin(ans, i != h - 1 ? dp[i + 1][j] + c + a[i][j] : Long.MAX_VALUE,
                        j != w - 1 ? dp[i][j + 1] + c + a[i][j] : Long.MAX_VALUE);
            }
        }
        System.out.println(ans);
    }

    private static long tripleMin(long a, long b, long c) {
        return Math.min(Math.min(a, b), c);
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
