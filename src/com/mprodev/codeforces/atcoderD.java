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

public class atcoderD {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        long[][] arr = new long[m][2];
        long[] min = {0, Long.MAX_VALUE};
        for (int i = 0; i < m; i++) {
            arr[i][0] = fs.nextLong();
            arr[i][1] = fs.nextLong();
            if (arr[i][1] < min[1]) {
                min = arr[i];
            }
        }
        if (n%min[0]!=0) {
            System.out.println((n-1)*min[1]);
        } else {

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
