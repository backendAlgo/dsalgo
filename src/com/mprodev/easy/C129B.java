package com.mprodev.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * mprodev for codeforces
 */

public class C129B {

    public static void main(String[] args) {
        var fs = new FastScanner();
        int V = fs.nextInt(), E = fs.nextInt();
        Set<Integer>[] adj = new HashSet[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new HashSet<>();
        }
        for (int i = 0; i < E; i++) {
			int src = fs.nextInt(), dest = fs.nextInt();
			src--; dest--;
			adj[src].add(dest);
			adj[dest].add(src);
		}
        int ans = 0;
        boolean flag = true;
        ArrayList<Integer> forDeleting = new ArrayList<>();
        while (true) {
            flag = false;
            for (int i = 0; i < V; i++) {
                if (adj[i].size() == 1) {
                    forDeleting.add(i);
                    flag = true;
                    adj[i].clear();
                }
            }
            if (!flag)
                break;
            else {
                for (int i = 0; i < V; i++) {
                    var curr = adj[i];
                    for (int j : forDeleting) {
                        curr.remove(j);
                    }
                }
            }
            forDeleting.clear();
            ans++;
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
