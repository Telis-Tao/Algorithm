package com.leetcode.oj.easy.valid_sudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the
 * filled cells need to be validated.
 * 
 * @author Telis
 * 
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String[] strs = {".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
		String[] strs1 = {"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"};
		char[][] board = new char[9][9];
		for (int i = 0; i < board.length; i++) {
			board[i] = strs1[i].toCharArray();
			System.out.println(board[i]);
		}
		System.out.println(s.isValidSudoku(board));
	}

	public boolean isValidSudoku(char[][] board) {
		int lenth = board.length;
		Set<Character> s = new HashSet<>();
		// 每一行
		for (int j = 0; j < lenth; j++) {
			for (int i = 0; i < lenth; i++) {
				if (board[j][i] != '.')
					if (!s.add(board[j][i]))
						return false;
			}
			s.clear();
		}
		System.out.println("row");
		// 每一列
		for (int j = 0; j < lenth; j++) {
			for (int i = 0; i < lenth; i++) {
				if (board[i][j] != '.')
					if (!s.add(board[i][j]))
						return false;
			}
			s.clear();
		}
		System.out.println("column");
		// 每一框
		char[][] temp = new char[3][3];
		for (int i = 0; i < lenth; i += 3) {
			for (int j = 0; j < lenth; j += 3) {
				for (int j2 = i; j2 < i+3; j2++) {
					for (int k = j; k < j+3; k++) {
						temp[j2-i][k-j] = board[j2][k];//这里有问题，已经能看出来了，吃完饭改
					}
				}
				if (!isValidSmall(temp))
					return false;
			}
		}
		return true;
	}

	public boolean isValidSmall(char[][] board) {
		int lenth = board.length;
		Set<Character> s = new HashSet<>();
		for (int i = 0; i < lenth; i++) {
			for (int j = 0; j < lenth; j++) {
				if (board[j][i] != '.')
					if (!s.add(board[j][i]))
						return false;
			}
		}
		return true;
	}
}
