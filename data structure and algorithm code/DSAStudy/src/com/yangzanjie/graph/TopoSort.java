package com.yangzanjie.graph;

import java.util.LinkedList;

/**
 * @author : yangzanjie
 * create at:  2019-09-26  20:36
 * @description: 拓扑排序算法实现
 *  采用有向无环图
 */
public class TopoSort {
    //有向无环图
    //若a先于b，则添加一条a指向b的边

    //顶点的数量
    private int v;

    //邻接表
    private LinkedList<Integer>[] adj;

    public TopoSort(int v) {
        this.v = v;
        for (int i = 0; i < v; i++)  {
            adj[i] = new LinkedList<>();
        }
    }

    public void topoSortByKahn() {
        int[] inDegree = new int[v];
        //统计每个顶点的入度
        for (int i = 0; i < v; i++) {
            for (Integer value : adj[i]) {
                inDegree[i]++;
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(" --> " + node);
            for (int i : adj[node]) {
                inDegree[i]--;
                if (inDegree[i] == 0) queue.add(i);
            }
        }
    }

    public void topoSortByDFS() {
        //构建逆邻接表，边s->t，表示s依赖于t，t优先于s
        LinkedList<Integer>[] inverseAdj =  new LinkedList[v];
        for (int i = 0; i < v; i++) { //申请空间
            inverseAdj[i] = new LinkedList<>();
        }

        //根据邻接表，生成逆邻接表
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);   // i -> w
                inverseAdj[w].add(i);    // w -> i
            }
        }

        boolean[] visited = new boolean[v];
        for (int i = 0; i< v; i++) {   //深度优先遍历图
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }

    private void dfs(int vertex, LinkedList<Integer> inverseAdj[], boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); i++) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w]) continue;
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        }
        //先把vertex这个顶点可达的所有顶点都打印出来，再打印自己
        System.out.println(vertex + " --> ");
    }
}
