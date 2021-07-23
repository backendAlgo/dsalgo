package com.mprodev.codeforces.roundA2021;

import com.mprodev.codeforces.c690.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

/*
 * mprodev for codeforces
 */

public class LShapedPlots {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int T = fs.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            int r = fs.nextInt(), c = fs.nextInt();
            int[][] matrix = new int[r][c];
            for (int i = 0; i < r; i++)
                matrix[i] = fs.readArray(c);
            Pair[][] goodRows = new Pair[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    int len = 0;
                    int begin = j;
                    while (j < c && matrix[i][j] == 1) {
                        len++;
                        j++;
                    }
                    int end = j - 1;
                    if (len >= 2) {
                        int temp = 1;
                        for (int k = begin; k <= end; k++) {
                            int key = len--;
                            int value = temp++;
                            if (key < 2) key = 0;
                            if (value < 2) value = 0;
                            goodRows[i][k] = new Pair(key, value);
                        }
                    }
                }
            }
            Pair[][] goodCols = new Pair[r][c];
            for (int i = 0; i < c; i++) {
                for (int j = 0; j < r; j++) {
                    int len = 0;
                    int begin = j;
                    while (j < r && matrix[j][i] == 1) {
                        len++;
                        j++;
                    }
                    int end = j - 1;
                    if (len >= 2) {
                        int temp = 1;
                        for (int k = begin; k <= end; k++) {
                            int key = len--;
                            int value = temp++;
                            if (key < 2) key = 0;
                            if (value < 2) value = 0;
                            goodCols[k][i] = new Pair(key, value);
                        }
                    }
                }
            }
//            System.out.println(Arrays.deepToString(goodRows));
//            System.out.println(Arrays.deepToString(goodCols));
            int count = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (goodRows[i][j] != null && goodCols[i][j] != null) {
                        var row = goodRows[i][j].data;
                        var col = goodCols[i][j].data;
                        int inc = 0;
                        for (int rowVal : row) {
                            if (rowVal != 0)
                                for (int colVal : col) {
                                    if (colVal != 0) {
                                        int temp = Math.min(rowVal, colVal * 2);
                                        inc += (temp / 2 - 1);
                                        temp = Math.min(colVal, rowVal * 2);
                                        inc += (temp / 2 - 1);
                                    }
                                }
                        }
//                        System.out.println("i:" + i + " j:" + j + " inc:" + inc);
                        count += inc;
                    }
                }
            }
            print(tt, count);
        }
    }

    static class Pair {
        int[] data = new int[2];

        public Pair(int begin, int len) {
            data[0] = begin;
            data[1] = len;
        }

        @Override
        public String toString() {
            return '{' + Arrays.toString(data) +
                    '}';
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

    static void print(int testCase, int data) {
        System.out.println("Case #" + testCase + ": " + data);
    }
}
