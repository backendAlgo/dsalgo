package com.mprodev.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * mprodev for codeforces
 */

public class C1418C {

	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		var T=fs.nextInt();
		for (int tt=0; tt<T; tt++) {
			var n = fs.nextInt();
			var a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = fs.nextInt();
			}
			//him[i] -- smallest # of skip points required to kill bosses. [i, n)
			//if it's our friend's turn on move
			//us[i] -- ...
			var him = new int[n + 1];
			var me = new int[n + 1];
			me[n] = him[n] = 0;
			for (int i = n - 1; i >= 0; i--) {
				//calculate him
				him[i] = me[i + 1] + a[i];
				if (i + 2 <= n)
					him[i] = Math.min(him[i], me[i + 2] + a[i] + a[i + 1]);
				//calculate me
				me[i] = him[i + 1];
				if (i + 2 <= n) {
					me[i] = Math.min(me[i], him[i + 2]);
				}
			}
			System.out.println(him[0]);
		}

	}

	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}

	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}


}
