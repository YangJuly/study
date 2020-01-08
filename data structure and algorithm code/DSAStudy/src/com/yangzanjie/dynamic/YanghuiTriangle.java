package com.yangzanjie.dynamic;

/**
 * @author : yangzanjie
 * create at:  2019-12-09  20:26
 * @description: 杨辉三角，求最短路径长
 */
public class YanghuiTriangle {
    public int calculate(int[][] matrix) {
        int[][] states = new int[matrix.length][matrix.length];
        states[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0) {
                    states[i][j] = states[i-1][j] + matrix[i][j];
                } else if (j == matrix[i].length - 1) {
                    states[i][j] = states[i-1][j-1] + matrix[i][j];
                } else {
                    states[i][j] = Math.min(states[i-1][j-1], states[i-1][j]) + matrix[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < states[0].length; i++) {
            if (min > states[states.length-1][i]) min = states[states.length-1][i];
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = {{5},{7,8},{2,3,4},{4,9,6,1},{2,7,9,4,5}};
        System.out.println(new YanghuiTriangle().calculate(matrix));
    }
}
