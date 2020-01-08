package com.demo.set;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : yangzanjie
 * create at:  2019-12-28  11:13
 * @description:
 */
public class Solution8 {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int shortestDistance(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        int[][] count = new int[n][m];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    cnt++;
                    boolean[][] visited = new boolean[n][m];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i, j, 0});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] pos =  queue.poll();

                        for (int k = 0; k < dirs.length; k++) {
                            int nextX = pos[0] + dirs[k][0];
                            int nextY = pos[1] + dirs[k][1];

                            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || visited[nextX][nextY] || grid[nextX][nextY] != 0) {
                                continue;
                            }
                            int curDistance = pos[2] + 1;
                            visited[nextX][nextY] = true;
                            queue.add(new int[]{nextX, nextY, curDistance});
                            dist[nextX][nextY] += curDistance;
                            count[nextX][nextY]++;
                        }
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (count[i][j] == cnt) {
                    res = Math.min(res, dist[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    public static void main(String[] args) {
        int[][] grid = {
                {1,0,2,0,1},
                {0,0,2,0,0},
                {0,0,0,0,0}
        };
        System.out.println(new Solution8().shortestDistance(grid));
    }
}
