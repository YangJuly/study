package com.demo.set;

import java.util.Arrays;

/**
 * @author : yangzanjie
 * create at:  2019-12-27  21:57
 * @description: 并查集
 */
public class DSUnionSolution {
    class DSUnion {
        int n;
        int[] parent;
        int[] rank;
        int count;

        public DSUnion (int n) {
            this.n = n;
            count = n;
            parent = new int[n];
            Arrays.fill(parent, -1);
            rank = new int[n];
        }

        public int find(int x) {
            while (parent[x] != -1) {
                x = parent[x];
            }
            return x;
        }

        public boolean union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) {
                return false;
            }
            if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot] += 1;
            }
            count--;
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        DSUnion dsUnion = new DSUnion(n);
        for (int[] edge : edges) {
            if (!dsUnion.union(edge[0], edge[1])) {
                return false;
            }
        }
        return (dsUnion.count == 1 ? true : false);
    }
}
