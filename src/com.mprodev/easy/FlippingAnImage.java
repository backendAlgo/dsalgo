package com.mprodev.easy;
/* Mirshod created on 2/1/2021 */

import java.util.Arrays;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int column = A[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < (column+1) / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][column-j-1];
                A[i][column-j-1] = temp;
                if (A[i][j] == 1) A[i][j] = 0;
                else A[i][j] = 1;
                if (j != column / 2) {
                    if (A[i][column-j-1] == 1) A[i][column-j-1] = 0;
                    else A[i][column-j-1] = 1;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(
                new FlippingAnImage().flipAndInvertImage(
                        new int[][] {
                                new int[]{1,1,0},
                                new int[]{1,0,1},
                                new int[]{0,0,0}
                        }
                )
        ));
    }
}
