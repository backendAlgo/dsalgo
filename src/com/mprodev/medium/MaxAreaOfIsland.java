package com.mprodev.medium;
/* Mirshod created on 2/10/2021 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int answer = 0;
        int[][] direction = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };
        class Pair {
            private final int a, b;

            private Pair(int a, int b) {
                this.a = a;
                this.b = b;
            }
        }
        boolean[][] visited = new boolean[row][column];
        Arrays.stream(visited).forEach(a -> Arrays.fill(a, false));
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int localAnswer = 1;
                    visited[i][j] = true;
                    //bfs
                    Queue<Pair> q = new ArrayDeque<>();
                    q.offer(new Pair(i, j));
                    Pair curr;
                    int newRow, newCol;

                    while (!q.isEmpty()) {
                        curr = q.poll();
                        for (int[] a : direction) {
                            newRow = a[0] + curr.a;
                            newCol = a[1] + curr.b;
                            if (newRow < row && newRow >= 0
                                    && newCol < column && newCol >= 0
                                    && !visited[newRow][newCol]
                                    && grid[newRow][newCol] == 1
                            ) {
                                localAnswer++;
                                visited[newRow][newCol] = true;
                                q.offer(new Pair(newRow, newCol));
                            }
                        }
                    }
                    answer = Math.max(localAnswer, answer);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(
                new MaxAreaOfIsland().maxAreaOfIsland(
                        new int[][]{
                                {1, 1, 0, 0, 0},
                                {1, 1, 0, 0, 0},
                                {0, 0, 0, 1, 1},
                                {0, 0, 0, 1, 1}
                        }
                )
        );
    }
}
