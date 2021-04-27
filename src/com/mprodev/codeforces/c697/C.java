package com.mprodev.codeforces.c697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* 
 * mprodev for codeforces
*/

public class C {
	//solution 1) more easy way using just thinking
	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		int T=fs.nextInt();
		for (int tt=0; tt<T; tt++) {
			int a = fs.nextInt(),
					b = fs.nextInt(),
					k = fs.nextInt();
			int[] boyP = new int[k], girlP = new int[k];
			for (int i = 0; i < k; i++) {
				boyP[i] = fs.nextInt()-1;
			}
			for (int i = 0; i < k; i++) {
				girlP[i] = fs.nextInt()-1;
			}
			int[] boyOutDegree = new int[a], girOutDegree = new int[b];
			for (int i = 0; i < k; i++) {
				boyOutDegree[boyP[i]]++;
				girOutDegree[girlP[i]]++;
			}
			long ans = 0;
			for (int i = 0; i < k; i++) {
				ans += (k - 1) - (boyOutDegree[boyP[i]] - 1)
						- (girOutDegree[girlP[i]] - 1);
			}
			System.out.println(ans / 2);
		}

		//solution 2) using purely combinatorics look at the comments

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
