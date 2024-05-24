package com.pyhita.test;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author pyhita
 * @Date 2024/5/22
 * @Description
 */
public class Debug {

    public static void main(String[] args) {
        System.out.println(new Debug().solveNQueens(2));
    }

    private List<List<String>> res;
    private char[][] board;
    private int n;
    public List<List<String>> solveNQueens(int n) {
        this.res = new ArrayList<>();
        this.board = new char[n][n];
        this.n = n;

        // 初始化 board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        dfs(0);
        return res;
    }

    private void dfs(int row) {
        // 遍历完了一遍
        if (row == n) {
            res.add(buildPath());
            return;
        }

        // 选择放置在那一列
        for (int i = 0;i < n;i++) {
            if (isValid(row, i)) {
                // 第row行放在第i 列
                board[row][i] = 'Q';
                dfs((row + 1));
                board[row][i] = '.';
            }
        }
    }

    private boolean isValid(int row, int col) {
        // check有没有在同一列的
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // check 对角线
        int i = row - 1, j = col + 1;
        while (i >= 0 && j < n) {
            if (board[i--][j++] == 'Q') return false;
        }

        i = row - 1;
        j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i--][j--] == 'Q') return false;
        }

        return true;
    }

    private List<String> buildPath() {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            path.add(new String(board[i]));
        }

        return path;
    }
}
