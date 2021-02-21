package com.mprodev.medium;
/* Mirshod created on 2/17/2021 */
// I can use Kosaraju's algorithm to find number of Provinces
//but it is undirected graph so I can just use DFS
//according to the problem province is like strongly connected components
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean[] visited = new boolean[V];
        int result = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                result++;
                DFS(i, isConnected, visited, V);
            }
        }
        return result;
    }
    private static void DFS(int curr,
                            int[][] isConnected,
                            boolean[] visited,
                            int V) {
        visited[curr] = true;
        for (int i = 0; i < V; i++) {
            if (i != curr
                    && isConnected[curr][i] == 1
                    && !visited[i]
            ) {
                DFS(i, isConnected, visited, V);
            }
        }
    }
}
