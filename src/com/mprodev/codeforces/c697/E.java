package com.mprodev.codeforces.c697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * mprodev for codeforces
 */

public class E {
    private static final long MOD = 1_000_000_007;

    static long mult(long a, long b) {
        return a * b % MOD;
    }

    static long fact(int x) {
        long ans = 1;
        for (int i = 2; i <= x; i++) {
            ans = mult(ans, i);
        }
        return ans;
    }

    static long fastPow(long base, long exp) {
        if (exp == 0) return 1;
        long half = fastPow(base, exp / 2);
        if (exp % 2 == 0) return mult(half, half);
        else return mult(half, mult(half, base));
    }

    static long modInv(long x) {
        return fastPow(x, MOD - 2);
    }

    static long nCk(int n, int k) {
        return mult(fact(n), mult(modInv(fact(k)), modInv(fact(n - k))));
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int T = fs.nextInt();
        for (int tt = 0; tt < T; tt++) {
            int n = fs.nextInt(), k = fs.nextInt();
            var a = fs.readArray(n);
            Arrays.sort(a);
            int last = a[n - k];
            int count = 0;
            int toPick = 0;
            for (int i : a) if (i == last) count++;
            for (int i = 0; i < k; i++) if (a[n - 1 - i] == last) toPick++;
            System.out.println(nCk(count, toPick));
        }

    }

    static long combinatorics(int n, int m) {
        long top = 1;
        for (long i = m + 1; i <= n; i++) {
            top = (top * i) % MOD;
        }
        long bottom = 1;
        for (long i = 1; i <= n - m; i++) {
            bottom = (bottom * i) % MOD;
        }
        return top / bottom;
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
