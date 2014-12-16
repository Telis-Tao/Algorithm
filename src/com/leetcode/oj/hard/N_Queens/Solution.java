package com.leetcode.oj.hard.N_Queens;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * @author Telis
 * 
 */
public class Solution {
	int[] results;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().solveNQueens(8));
	}

	public List<String[]> solveNQueens(int n) {
		results = new int[n];
		List<String[]> list = new ArrayList<String[]>();
		solveNQueens(n, 0, list);
//		 System.out.println(list);
		return list;
	}

	public void solveNQueens(int n, int count, List<String[]> list) {
		if (count == n) {
			String[] strs = new String[n];
			for (int i = 0; i < results.length; i++) {
				StringBuffer sb = new StringBuffer();
				for (int j = 0; j < results[i]; j++) {
					sb.append('.');
				}
				sb.append('Q');
				for (int j = results[i] + 1; j < strs.length; j++) {
					sb.append('.');
				}
				strs[i] = sb.toString();
			}
			list.add(strs);
//			for (int i = 0; i < strs.length; i++) {
//				System.out.println(strs[i]);
//			}
//			System.out.println();
		} else {
			for (int i = 0; i < n; i++) {
				results[count] = i;
				if (isAvailable(count)) {
					solveNQueens(n, count + 1, list);
				}
			}
		}

	}

	/**
	 * 判断是否跟以前的皇后有冲突(在results里存着位置，i代表第几行，里面的数字代表第几列)
	 * 
	 * @param count
	 *            第几个皇后
	 * @return
	 */
	private boolean isAvailable(int count) {
		// TODO Auto-generated method stub
		for (int i = 0; i < count; i++) {
			// 是否是同一列
			if (results[i] == results[count]) {
				return false;
			}
			// 是否斜着会碰上
			if (Math.abs(results[i] - results[count]) == Math.abs(i - count)) {
				return false;
			}
		}
		return true;
	}
}
