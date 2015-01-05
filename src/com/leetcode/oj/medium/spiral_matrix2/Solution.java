package com.leetcode.oj.medium.spiral_matrix2;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * For example, Given n = 3,
 * 
 * You should return the following matrix: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5
 * ] ]
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
		s.generateMatrix(0);
	}

	public int[][] generateMatrix(int n) {
		if(n<0)
			return new int[0][0];
		int[][] results = new int[n][n];
		int left, right, up, down;
		left = 0;
		right = n - 1;
		up = 0;
		down = n - 1;
		int count = 1;
		while (left <= right && up <= down) {
			for (int i = left; i <= right; i++) {
				results[up][i] = count++;
			}
			up++;
			for (int i = up; i <= down; i++) {
				results[i][right] = count++;
			}
			right--;
			for (int i = right; i >= left; i--) {
				results[down][i] = count++;
			}
			down--;
			for (int i = down; i >= up; i--) {
				results[i][left] = count++;
			}
			left++;
		}
//		ArrayTools.iter(results);
		return results;
	}
}
