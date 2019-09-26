package com.yangzanjie.graph;

/**
 * @author : yangzanjie
 * create at:  2019-09-25  15:26
 * @description: Dijkstra算法实现
 */
public class Dijkstra {
    public static final int M = 10000; // 代表正无穷

    public static void main(String[] args) {
        // 二维数组每一行分别是 A、B、C、D、E 各点到其余点的距离,
        // A -> A 距离为0, 常量M 为正无穷
        int[][] weight1 = {
                {0,4,M,2,M},
                {4,0,4,1,M},
                {M,4,0,1,3},
                {2,1,1,0,7},
                {M,M,3,7,0}
        };

        int start = 0;

        int[] shortPath = dijkstra(weight1, start);

        for (int i = 0; i < shortPath.length; i++)
            System.out.println("从" + start + "出发到" + i + "的最短距离为：" + shortPath[i]);
    }

    public static int[] dijkstra(int[][] weight, int start) {
        //weight 有向图的权重矩阵，start 起点
        int n = weight.length;
        int[] shortPath = new int[n];
        String[] path = new String[n];
        for (int i = 0; i < n; i++) {
            path[i] = new String(start + "-->" + i);
        }
        int[] visited = new int[n];

        shortPath[start] = 0;
        visited[start] = 1;

        for (int count = 1; count < n; count++) {
            int k = -1; //选出一个距离初始顶点start最近的未标记顶点
            int dmin = Integer.MAX_VALUE;

            //从集合U中选出距离start距离最近的点，进而更新集合S
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0 && weight[start][i] < dmin) {
                    dmin = weight[start][i];
                    k = i;
                }
            }

            // 将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin
            shortPath[k] = dmin;
            visited[k] = 1;

            //以k为中间点，修正start未方位的点的距离
            for (int i = 0; i < n; i++) {
                //如果'起始点到当前的距离' + '当前点到某点距离' < '起始点到某点距离'，则更新
                if (visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]) {
                    weight[start][i] = weight[start][k] + weight[k][i];
                    path[i] = path[k] + " --> " + i;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("From " + start + " to " + i + ", the shortest path:" + path[i]);
        }
        System.out.println("********************************************");
        return shortPath;
    }
}
