package com.leetcode.oj.medium;

/**
 * Created by appleowner on 4/21/15.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] cw = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exists(board, i, j, cw, 0)) return true;
            }
        }
        return false;
    }

    public boolean exists(char[][] board, int row, int col, char[] word, int idx) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (board[row][col] != word[idx]) return false;
        if (idx == word.length - 1) return true;
        board[row][col] ^= 256;
        boolean ret = exists(board, row - 1, col, word, idx + 1) ||
                exists(board, row + 1, col, word, idx + 1) ||
                exists(board, row, col - 1, word, idx + 1) ||
                exists(board, row, col + 1, word, idx + 1);
        board[row][col] ^= 256;
        return ret;
    }
}
