package com.mprodev.codeforces.c697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
 * mprodev for codeforces
*/
// using sorting and two pointers approach
public class D {
	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		int T=fs.nextInt();
		for (int tt=0; tt<T; tt++) {
			int n = fs.nextInt(), m = fs.nextInt();
			var a = fs.readArray(n);
			var b = fs.readArray(n);
			var regular = new ArrayList<Integer>();
			var important = new ArrayList<Integer>();
			for (int i = 0; i < a.length; i++) {
				if (b[i] == 1)
					regular.add(a[i]);
				else
					important.add(a[i]);
			}
			regular.sort(Comparator.comparingInt(e -> -e));
			important.sort(Comparator.comparingInt(e -> -e));
			int p1, p2 = 0;
			int curr = 0;
			int ans = 0;
			while (p2 < important.size() && curr < m) {
				curr += important.get(p2);
				p2++;
				ans += 2;
			}
			int temp = ans;
			if (curr < m) {
				ans = Integer.MAX_VALUE;
			}
			p2--;
			for (p1 = 0; p1 < regular.size(); p1++) {
				curr += regular.get(p1);
				temp++;
				while (p2 >= 0 && curr - important.get(p2)>=m) {
					curr = curr - important.get(p2);
					temp-=2;
					p2--;
				}
				if (curr >= m)
					ans = Math.min(ans, temp);
			}
			System.out.println(ans != Integer.MAX_VALUE ? ans : -1);
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
