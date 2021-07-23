package com.mprodev.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * mprodev for codeforces
 */

public class atcoderC {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        int[] arr = fs.readArray(n);
        Map<Integer, Integer> store = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < k; i++) {
            store.merge(arr[i], 1, Integer::sum);
        }
        ans = store.size();
        for (int i = k; i < n; i++) {
            store.computeIfPresent(arr[i - k], (key, val) -> {
                if (val == 1)
                    return null;
                else
                    return val - 1;
            });
            store.merge(arr[i], 1, Integer::sum);
            ans = Math.max(ans, store.size());
        }
        System.out.println(ans);
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
