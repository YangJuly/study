package com.yangzanjie.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : yangzanjie
 * create at:  2019-09-24  18:58
 * @description: 无向图：邻接表实现
 */
public class Graph {
    private int v; //顶点的个数
    private LinkedList<Integer> adj[];  //邻接表

    public Graph(int v) {
        this.v = v;
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度搜索
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        if (t == s) return;
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i=0; i<v; i++) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        //打印该最短路径
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.println(t + " ");
    }

    boolean found = false;

    /**
     * 深度搜索
     * @param s
     * @param t
     */
    public void dfs (int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if (visited[q] != true) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }
}
