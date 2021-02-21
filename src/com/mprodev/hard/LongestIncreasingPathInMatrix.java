package com.mprodev.hard;
/* Mirshod created on 2/19/2021 */

public class LongestIncreasingPathInMatrix {
    // solution 1 using topological sort like algorithm

    //fixed array for to make possible moving directions
    private final int[][] directions = new int[][]{
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{0, -1}
    };
    private int R, C;
    int[][] dp;
    int[][] matrix;
    public int longestIncreasingPath(int[][] matrix) {
         R = matrix.length;
         C = matrix[0].length;
         this.matrix = matrix;
        dp = new int[R][C];
        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans = Math.max(ans, helper(i, j));
            }
        }
        return ans;
    }

    // function to calculate minimum distance for given coordinate
    private int helper(int r, int c) {
        if (dp[r][c] != 0) {
            return dp[r][c];
        }
        int currAns = 0;
        for (int[] direction : directions) {
            int possibleR = direction[0] + r;
            int possibleC = direction[1] + c;
            if (possibleC < 0 || possibleC >= C ||
            possibleR < 0 || possibleR >= R)
                continue;
            if (matrix[r][c] >= matrix[possibleR][possibleC])
                continue;
            currAns = Math.max(currAns, helper(possibleR, possibleC));
        }
        return dp[r][c] = currAns + 1;
    }
}
