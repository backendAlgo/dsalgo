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

public class B {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int T = fs.nextInt();
        test:
        for (int tt = 0; tt < T; tt++) {
            int n = fs.nextInt();
            var line = fs.next().toCharArray();
            var target = "2020".toCharArray();
            outer:
            for (int i = 0; i <= 4; i++) {
                for (int j = 0; j < i; j++) {
                    if (target[j] != line[j]) continue outer;
                }
                for (int j = 0; j < 4 - i; j++) {
                    if (target[i + j] != line[n - 4 + i + j]) continue outer;
                }
                System.out.println("YES");
                continue test;
            }
            System.out.println("NO");
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
