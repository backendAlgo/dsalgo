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

public class D {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int T = fs.nextInt();
        test:
        for (int tt = 0; tt < T; tt++) {
            int n = fs.nextInt();
            var a = fs.readArray(n);
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += a[i];
            }
            for (int i = 0; i < n; i++) {
                if (sum % (n - i) == 0 && isPossible(a, i, sum)) {
                    System.out.println(i);
                    continue test;
                }
            }
        }

    }

    static boolean isPossible(int[] a, int steps, final int sum) {
        int n = a.length;
        int maxAll = sum / (n - steps);
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr += a[i];
            if (curr == maxAll)
                curr = 0;
            else if (curr > maxAll)
                return false;
        }
        return true;
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
