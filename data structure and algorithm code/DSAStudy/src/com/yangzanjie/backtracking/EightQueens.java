package com.yangzanjie.backtracking;

/**
 * @author : yangzanjie
 * create at:  2019-10-10  10:51
 * @description: 八皇后问题求解
 */
public class EightQueens {
    private int[] results = new int[8];

    public EightQueens() {
        for (int i = 0; i < 8; i++) {
            results[i] = 0;
        }
    }

    public void cal8queens(int row) {
        if (row == 8) {
            printQueens(results);
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isOk(column, row)) {
                results[row] = column;
                cal8queens(row+1);
            }
        }
    }

    private boolean isOk(int column, int row) {
        int leftup = column - 1;
        int rightup = column + 1;
        for (int i = row - 1; i >= 0; i--) { //逐行往上考察每一行
            if (results[i] == column) return false; //第i行的column列 有棋子吗？
            if (leftup >= 0 && results[i] == leftup) {
                return false; //考察左上对角线,第i行leftup上有棋子吗？
            }
            if (rightup < 8 && results[i] == rightup) {
                return false; //考察右上对角线，第i行rightup上有棋子吗？
            }
            leftup--;
            rightup++;
        }
        return true;
    }

    private void printQueens(int[] results) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (results[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.cal8queens(0);
    }
}
