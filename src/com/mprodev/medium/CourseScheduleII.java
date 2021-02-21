package com.mprodev.medium;
/* Mirshod created on 2/16/2021 */

import java.util.ArrayList;
import java.util.LinkedList;

public class CourseScheduleII {
    //solution 1
    //solution using CourseSchedule I solution
    //so it is a bit ugly and with lots of repetitions
    //but time complexity the same as others
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (!canFinish(numCourses, prerequisites))
            return new int[]{};
        boolean[] visited = new boolean[numCourses];
        LinkedList<Integer>[] adj = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            adj[edge[0]].add(edge[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i])
                dfs(adj, i, visited, ans);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    static void dfs(LinkedList<Integer>[] adj, int curr,
                    boolean[] visited, LinkedList<Integer> ans) {
        visited[curr] = true;
        for (int adjacent : adj[curr]) {
            if (!visited[adjacent])
                dfs(adj, adjacent, visited, ans);
        }
        ans.add(curr);
    }

    //function to check is there any cycle
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
    //solution 2
    //using node in-degree (Kahn's Algorithm)


    //solution 3
    //dfs logic the same as solution 1 but
    //without repetitions (refactored code)
}
