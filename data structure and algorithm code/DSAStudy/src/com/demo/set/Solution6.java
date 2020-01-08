package com.demo.set;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author : yangzanjie
 * create at:  2019-12-27  19:17
 * @description:
 */
class Solution6 {

    class Node {
        int workerIndex;
        int bikeIndex;
        int mdDistance;

        public Node(int workerIndex, int bikeIndex, int mdDistance) {
            this.workerIndex = workerIndex;
            this.bikeIndex = bikeIndex;
            this.mdDistance = mdDistance;
        }
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;
        Node[] nodes = new Node[n * m];
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                nodes[i *  m + j] = new Node(i, j, calMDDistance(workers[i], bikes[j]));
            }
        }
        Arrays.sort(nodes, ((o1, o2) -> {
            if (o1.mdDistance != o2.mdDistance) {
                return o1.mdDistance - o2.mdDistance;
            } else {
                if (o1.workerIndex != o2.workerIndex) {
                    return o1.workerIndex - o2.workerIndex;
                }  else {
                    return o1.bikeIndex - o2.bikeIndex;
                }
            }
        }));

        int[] res = new int[n];
        boolean[] workerUsed = new boolean[n];
        boolean[] bikeUsed = new boolean[m];

        int count = 0;
        for (Node node : nodes) {
            if (!workerUsed[node.workerIndex] && !bikeUsed[node.bikeIndex]) {
                res[node.workerIndex] = node.bikeIndex;
                workerUsed[node.workerIndex] = true;
                bikeUsed[node.bikeIndex] = true;
                count++;
            }
            if (count >= n) break;
        }
        return res;
    }

    public int calMDDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public static void main(String[] args) {

    }
}
