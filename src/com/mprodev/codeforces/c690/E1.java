package com.mprodev.codeforces.c690;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * mprodev for codeforces
 */

public class E1 {
    //Second Thread's approach using cumulative sums
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int T = fs.nextInt();
        for (int tt = 0; tt < T; tt++) {
            int n = fs.nextInt();
            var a = fs.readArray(n);
            int k = 2, m = 3;
            var freq = new int[n + 1];
            for (int i : a) freq[i]++;
            var prefixSum = new int[n + 2];
            for (int i = 1; i < prefixSum.length; i++)
                prefixSum[i] = prefixSum[i - 1] + freq[i - 1];
            long ans = 0;
            for (int curr = 0; curr < n + 1; curr++) {
                int possibleAll = prefixSum[curr] - prefixSum[Math.max(0, curr - k)];
                for (int j = 0; j < freq[curr]; j++) {
                    if (possibleAll + j + 1 >= m) {
                        ans += nC2(possibleAll + j);
                    }
                }
            }
            System.out.println(ans);
        }
    }

    static long nC2(long n) {
        return n * (n - 1) / 2;
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
