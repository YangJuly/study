package com.demo.set;

import java.util.*;

/**
 * @author : yangzanjie
 * create at:  2019-12-27  22:08
 * @description:
 */
public class Solution7 {
    //用链表法存储图，无向图 [0,1] 存为 0-1，1-0
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (map.containsKey(edge[0])) {
                map.get(edge[0]).add(edge[1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(edge[1]);
                map.put(edge[0], set);
            }

            if (map.containsKey(edge[1])) {
                map.get(edge[1]).add(edge[0]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(edge[0]);
                map.put(edge[1], set);
            }
        }

        boolean[] visited = new boolean[n];
        //bfs
        /**
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (map.get(cur) == null) continue;
            for (int i : map.get(cur)) {
                if (visited[i]) return false;
                queue.add(i);
                visited[i] = true;
                //remove
                map.get(i).remove(cur);
            }
        } **/

        //dfs
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            visited[cur] = true;
            if (map.get(cur) != null) {
                for (int i : map.get(cur)) {
                    if (visited[i]) return false;
                    visited[i] = true;
                    stack.push(i);
                    map.get(i).remove(cur);
                }
            }
        }

        for (boolean flag : visited) {
            if (!flag) return false;
        }

        return true;
    }
}
