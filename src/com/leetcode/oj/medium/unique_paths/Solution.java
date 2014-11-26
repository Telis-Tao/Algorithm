package com.leetcode.oj.medium.unique_paths;

import com.leetcode.oj.tools.ArrayTools;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.uniquePaths(3, 7));
	}
	public int uniquePaths(int m, int n) {
		int[][] results = new int[m][n];
		// 第一行：
		results[0][0] = 1;
		for (int i = 1; i < results[0].length; i++) {
			results[0][i] = 1;
		}
		// 第一列
		for (int i = 1; i < results.length; i++) {
			results[i][0] = 1;
		}
		for (int i = 1; i < results.length; i++) {
			for (int j = 1; j < results[i].length; j++) {
				results[i][j] = results[i-1][j]+results[i][j-1];
			}
		}
		ArrayTools.iter(results);
		return results[m-1][n-1];
	}
	
}
