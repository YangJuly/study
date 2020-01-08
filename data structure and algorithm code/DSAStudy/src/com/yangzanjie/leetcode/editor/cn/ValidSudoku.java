package com.yangzanjie.leetcode.editor.cn;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : yangzanjie
 * create at:  2019-09-28  13:08
 * @description: 36-有效的数独
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int nr = board.length;
        int nc = board[0].length;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (board[i][j] != '.') {
                    if (!isValid(board, i, j)) return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int r, int c) {
        int nr = board.length;
        int nc = board[0].length;

        char ch = board[r][c];
        //验证行
        for (int j = 0; j < nc; j++) {
            if (j != c && board[r][j] == ch) {
                return false;
            }
        }
        //验证列
        for (int i = 0; i < nr; i++) {
            if (i != r && board[i][c] == ch) {
                return false;
            }
        }

        //验证宫
        int pr = (r / 3);
        int pc = (c / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int indexI = i + pr * 3;
                int indexJ = j + pc * 3;
                if (indexI != r && indexJ != c && board[indexI][indexJ] == ch) {
                    return false;
                }
            }
        }
        return true;
    }
}
