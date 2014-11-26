package com.leetcode.oj.medium.minimum_path_sum;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minPathSum(int[][] grid) {
		int[][] results = new int[grid.length][grid[0].length];
		// 第一行：
		results[0][0] = grid[0][0];
		for (int i = 1; i < results[0].length; i++) {
			results[0][i] = results[0][i - 1] + grid[0][i];
		}
		// 第一列
		for (int i = 1; i < results.length; i++) {
			results[i][0] = results[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < results.length; i++) {
			for (int j = 1; j < results[i].length; j++) {
				results[i][j] = Math.min(results[i - 1][j], results[i][j-1])+grid[i][j];
			}
		}
		return results[grid.length-1][grid[0].length-1];
	}
}
