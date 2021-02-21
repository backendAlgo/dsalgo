package com.mprodev.medium;
/* Mirshod created on 2/16/2021 */

import java.util.ArrayList;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<>();
        for (int[] edge : prerequisites) {
            adj[edge[0]].add(edge[1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] inProcess = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(adj, i, visited, inProcess))
                return false;
        }
        return true;
    }
    //this function checks is given directed graph has cycles or not
    //return true if there is cycle
    //else return false
    static boolean isCyclic(ArrayList<Integer>[] adj, int curr, boolean[] visited, boolean[] inProcess) {
        if (inProcess[curr])
            return true;
        if (visited[curr])
            return false;
        inProcess[curr] = true;
        visited[curr] = true;
        for (int adjacent : adj[curr]) {
            if (isCyclic(adj, adjacent, visited, inProcess))
                return true;
        }
        inProcess[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(
                new CourseSchedule().canFinish(2, new int[][] {{1,0}})
        );
    }
}
