package com.mprodev.medium;
/* Mirshod created on 2/4/2021 */


public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        int i = 0;
        int j = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int[] ans = new int[row * column];
        int index = 0;
        while (i != matrix[row-1][column-1]) {
            ans[index++] = matrix[i][j];
            if (i == 0) j++;
            else if (j == 0) i++;
            else {

            }
        }
        return ans;
    }
}
