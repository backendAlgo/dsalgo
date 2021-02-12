package com.mprodev.medium;
/* Mirshod created on 2/4/2021 */


import java.util.LinkedList;
import java.util.List;

public class DiagonalTraverse {
    private interface Change {
        void change(int i, int j);
    }
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ans = new int[m * n];
        int k = 0;
        int i = 0, j = 0;
        boolean toggle = true;
        boolean toBottom = true;
        //for half of the matrix
        while(i != m -1  && j != n - 1) {
            if (i == m - 1 || j == n - 1) {
                toggle = false;
            }
            if (toggle) {

                if (toBottom) {

                }
            }
        }

        return ans;
    }
    private static void toRight(Integer i, Integer j) {
        j = j + 1;
    }
}
