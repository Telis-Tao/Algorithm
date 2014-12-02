package com.leetcode.oj.medium.surrounded_regions;

import java.util.LinkedList;
import com.leetcode.oj.tools.ArrayTools;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by
 * 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * For example, X X X X X O O X X X O X X O X X After running your function, the
 * board should be:
 * 
 * X X X X X X X X X X X X X O X X
 * 
 * @author Telis
 * 
 */
public class Solution {
	int[][] used;

	/**
	 * @author Telis
	 * 
	 */
	class Point {
		int row;
		int column;

		public Point(int row, int column) {
			this.row = row;
			this.column = column;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", column=" + column + "]";
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] str = { "XOXOOOO", "XOOOOOO", "XOOOOXO", "OOOOXOX", "OXOOOOO",
//				"OOOOOOO", "OXOOOOO" };
//		char[][] board = new char[str.length][str[0].length()];
//		for (int i = 0; i < str.length; i++) {
//			board[i] = str[i].toCharArray();
//		}
		 char[][] board = { { 'x', 'x', 'x'}, { 'x', 'o', 'x' },
		 { 'o', 'o', 'o' }};
		// char[][] board = { { 'o' } };
		Solution s = new Solution();
		System.out.println("data:");
		ArrayTools.iter(board);
		s.solve(board);
		System.out.println("result:");
		ArrayTools.iter(board);
	}

	public void solve(char[][] board) {
		if (board.length < 1 || board[0].length < 1) {
			return;
		}
		char[] c = new char[2];
		if (Character.isLowerCase(board[0][0])) {
			c[0] = 'o';
			c[1] = 'x';
		} else {
			c[0] = 'O';
			c[1] = 'X';
		}
		used = new int[board.length][board[0].length];
		// ±ßÔµ¼ì²â£º
		// row:
		for (int i = 0; i < board[0].length; i++) {
			if (used[0][i] == 0 && board[0][i] == c[0]) {
				mark(board, 0, i, c[0]);
			}
		}
		for (int i = 0; i < board[0].length; i++) {
			if (used[board.length - 1][i] == 0
					&& board[board.length - 1][i] == c[0]) {
				mark(board, board.length - 1, i, c[0]);
			}
		}
		// column
		for (int i = 0; i < board.length; i++) {
			if (used[i][0] == 0 && board[i][0] == c[0]) {
				mark(board, i, 0, c[0]);
			}
		}
		for (int i = 0; i < board.length; i++) {
			if (used[i][board[i].length - 1] == 0
					&& board[i][board[i].length - 1] == c[0]) {
				mark(board, i, board[i].length - 1, c[0]);
			}
		}
//		System.out.println("used:");
//		ArrayTools.iter(used);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == c[0] && used[i][j] == 0)
					board[i][j] = c[1];
			}
		}
	}

	public void mark(char[][] board, int row, int column, char c) {
		LinkedList<Point> list = new LinkedList<>();
		list.add(new Point(row, column));
		while (!list.isEmpty()) {
			Point p = list.pop();
			// if (p.row == 4 && p.column == 5) {
			// System.out.println("used:");
			// ArrayTools.iter(used);
			// }
			if (used[p.row][p.column] == 0 && board[p.row][p.column] == c) {
				used[p.row][p.column] = 1;
				if (p.row > 0 && used[p.row - 1][p.column] == 0) {
					list.push(new Point(p.row - 1, p.column));
				}
				if (p.row < board.length - 1 && used[p.row + 1][p.column] == 0) {
					list.push(new Point(p.row + 1, p.column));
				}
				if (p.column > 0 && used[p.row][p.column - 1] == 0) {
					list.push(new Point(p.row, p.column - 1));
				}
				if (p.column < board[p.row].length - 1
						&& used[p.row][p.column + 1] == 0) {
					list.push(new Point(p.row, p.column + 1));
				}
			}
		}
	}
}
