package com.leetcode.oj.medium;

import java.util.Stack;

/**
 * Created by appleowner on 3/21/15.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int height = board.length;
        int width = board[0].length;
        for (int col = 0; col < width; col++) {
            if (board[0][col] == 'O') bfsSearch(board, 0, col);
            if (board[height - 1][col] == 'O') bfsSearch(board, height - 1, col);
        }
        for (int row = 1; row < height - 1; row++) {
            if (board[row][0] == 'O') bfsSearch(board, row, 0);
            if (board[row][width - 1] == 'O') bfsSearch(board, row, width - 1);
        }
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                else if (board[r][c] == 'B') board[r][c] = 'O';
            }
        }
    }

    public void bfsSearch(char[][] board, int row, int col) {
        if (board[row][col] != 'O') return;
        int height = board.length;
        int width = board[0].length;

        Stack<Integer[]> stack = new Stack<Integer[]>();
        stack.add(new Integer[]{row, col});
        while (!stack.isEmpty()) {
            Integer[] pos = stack.pop();
            int r = pos[0];
            int c = pos[1];
            board[r][c] = 'B';
            Integer[][] adjArr = new Integer[][]{{r - 1, c}, {r + 1, c}, {r, c - 1}, {r, c + 1}};
            for (Integer[] adj : adjArr) {
                int adjR = adj[0];
                int adjC = adj[1];
                if (adjR >= 0 && adjR < height &&
                        adjC >= 0 && adjC < width &&
                        board[adjR][adjC] == 'O') {
                    stack.push(new Integer[]{adjR, adjC});
                }
            }
        }
    }
}
