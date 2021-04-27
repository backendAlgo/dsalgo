package com.mprodev.codeforces.c690;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * mprodev for codeforces
 */

public class E2 {
    private static final long MOD = 1_000_000_007;

//     solution using binarySearch which is got time limit exceed
//    public static void main(String[] args) {
//        preCompute();
//        FastScanner fs = new FastScanner();
//        PrintWriter out = new PrintWriter(System.out);
//        int T = fs.nextInt();
//        for (int tt = 0; tt < T; tt++) {
//            int n = fs.nextInt(), m = fs.nextInt(), k = fs.nextInt();
//            var a = fs.readArray(n);
//            Arrays.sort(a);
//            //11 222 33 4 555
//            //
//            long ans = 0;
//            for (int i = 0; i < n; i++) {
//                int left = i + 1;
//                int right = upperBound(a, a[i] + k);
//                ans = (ans + nCk(right - left, m - 1)) % MOD;
//            }
//            out.println(ans);
//        }
//        out.close();
//    }
    public static void main(String[] args) {
        preCompute();
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int T = fs.nextInt();
        for (int tt = 0; tt < T; tt++) {
            int n = fs.nextInt(),
                    m = fs.nextInt(),
                    k = fs.nextInt();
            var a = fs.readArray(n);
            var freq = new int[n + 1];
            for (int i : a) freq[i]++;
            var prefixSum = new int[n + 2];
            for (int i = 1; i < n + 2; i++)
                prefixSum[i] = prefixSum[i - 1] + freq[i - 1];
            long ans = 0;
            for (int curr = 0; curr < n + 1; curr++) {
                int possibleAll = prefixSum[curr] - prefixSum[Math.max(0, curr - k)];
                for (int j = 0; j < freq[curr]; j++) {
                    if (possibleAll + j + 1 >= m) {
                        long b = nCk(possibleAll + j, m - 1);
                        ans = add(ans, b);
                    }
                }
            }
            out.println(ans);
        }
        out.close();

    }

    static int upperBound(int[] a, int target) {
        int ans = Arrays.binarySearch(a, target);
        if (ans < 0) {
            return -1 - ans;
        } else {
            while (ans < a.length && a[ans] == target)
                ans++;
            return ans;
        }
    }

    static long add(long a, long b) {
        return (a + b) % MOD;
    }

    static long[] facts = new long[300_500];

    static long nCk(int n, int k) {
        if (k > n)
            return 0;
        return mul(facts[n],
                mul(modInv(facts[k]),
                        modInv(facts[n - k])));
    }

    static void preCompute() {
        facts[0] = 1;
        for (int i = 1; i < facts.length; i++)
            facts[i] = mul(facts[i - 1], i);
    }

    static long binPow(long a, long pow) {
        if (pow == 0) return 1;
        long half = binPow(a, pow / 2);
        if (pow % 2 == 1) return mul(half, mul(half, a));
        else return mul(half, half);
    }

    static long mul(long a, long b) {
        return a * b % MOD;
    }

    static long modInv(long a) {
        return binPow(a, MOD - 2);
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
