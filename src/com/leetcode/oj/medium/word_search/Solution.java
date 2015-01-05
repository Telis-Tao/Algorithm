package com.leetcode.oj.medium.word_search;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * 
 * [ ["ABCE"], ["SFCS"], ["ADEE"] ] word = "ABCCED", -> returns true, word =
 * "SEE", -> returns true, word = "ABCB", -> returns false.
 * 
 * @author Telis
 * 
 */
public class Solution {
	int[][] used;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
		// { 'A', 'D', 'E', 'E' } };
		char[][] board = { { 'A', 'B' } };
		Solution s = new Solution();
		// System.out.println(s.exist(board, "ABCCED"));
		// System.out.println(s.exist(board, "SEE"));
		// System.out.println(s.exist(board, "ADEE"));
		System.out.println(s.exist(board, "BA"));
	}

	public boolean exist(char[][] board, String word) {
		used = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (find(board, word, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean find(char[][] board, String word, int row, int column,
			int start) {
		if (start == word.length()) {
			return true;
		}
		if (row >= 0 && row < board.length && column >= 0
				&& column < board[row].length) {
			if (used[row][column] == 1) {
				return false;
			}
			if (board[row][column] == word.charAt(start)) {
				used[row][column] = 1;
				boolean b = find(board, word, row + 1, column, start + 1)
						|| find(board, word, row - 1, column, start + 1)
						|| find(board, word, row, column + 1, start + 1)
						|| find(board, word, row, column - 1, start + 1);
				used[row][column] = 0;
				return b;
			}
		}
		return false;
	}
}
