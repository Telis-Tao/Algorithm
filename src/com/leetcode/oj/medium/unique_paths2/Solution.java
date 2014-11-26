package com.leetcode.oj.medium.unique_paths2;

import com.leetcode.oj.tools.ArrayTools;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[][] obstacleGrid = {{0,0,0,0},{0,0,0,0},{0,0,1,0},{0,0,0,0}};
		// int[][] obstacleGrid = { { 0, 0 }, { 1, 0 } };
		// int[][] obstacleGrid = { { 1, 0 }};
		// int[][] obstacleGrid = { { 1, 0 }};
		int[][] obstacleGrid = { { 0, 0 }, { 1, 0 }, { 0, 0 } };
		ArrayTools.iter(obstacleGrid);
		System.out.println("result:");
		Solution s = new Solution();
		System.out.println(s.uniquePathsWithObstacles(obstacleGrid));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid[0][0] == 1)
			return 0;
		if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] results = new int[m][n];
		// 第一行：
		results[0][0] = 1;
		for (int i = 1; i < results[0].length; i++) {
			if (obstacleGrid[0][i] == 1)
				break;
			if (obstacleGrid[0][i] == 0)
				results[0][i] = 1;
		}
		// 第一列
		for (int i = 1; i < results.length; i++) {
			if (obstacleGrid[i][0] == 1)
				break;
			if (obstacleGrid[i][0] == 0)
				results[i][0] = 1;
		}
		for (int i = 1; i < results.length; i++) {
			for (int j = 1; j < results[i].length; j++) {
				if (obstacleGrid[i][j] == 0) {
					results[i][j] = results[i - 1][j] + results[i][j - 1];
				}
			}
		}
		ArrayTools.iter(results);
		return results[m - 1][n - 1];
	}
}
