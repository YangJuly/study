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
        HashMap<Integer, Integer> row[] = new HashMap[9];
        HashMap<Integer, Integer> column[] = new HashMap[9];
        HashMap<Integer, Integer> box[] = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashMap<>();
            column[i] = new HashMap<>();
            box[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = (int) c;

                    int boxIndex = (i / 3) * 3 + j / 3;

                    row[i].put(num, row[i].getOrDefault(num, 0) + 1);
                    column[j].put(num, column[j].getOrDefault(num, 0) + 1);
                    box[boxIndex].put(num, box[boxIndex].getOrDefault(num, 0) + 1);

                    if (row[i].get(num) > 1 || column[j].get(num) > 1 || box[boxIndex].get(num) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
