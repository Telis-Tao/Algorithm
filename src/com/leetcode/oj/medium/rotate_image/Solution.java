package com.leetcode.oj.medium.rotate_image;

import com.leetcode.oj.tools.ArrayTools;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up: Could you do this in-place?
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
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		Solution s = new Solution();
		ArrayTools.iter(matrix);
		s.rotate(matrix);
		ArrayTools.iter(matrix);
	}

	public void rotate(int[][] matrix) {
		if (matrix.length <= 1) {
			return;
		}
		int n = matrix.length - 1;
		int count = 0;
		// System.out.println(n);
		while (count <= n / 2) {
			// System.out.println(count + ":" + n);
			for (int i = count; i < n - count; i++) {
				switchMatrix(matrix, count, i);
			}
			count++;
		}
	}

	private void switchMatrix(int[][] matrix, int i, int j) {
		// TODO Auto-generated method stub
		int n = matrix.length - 1;
		int former = matrix[i][j];
		int next = matrix[j][n - i];
		matrix[j][n - i] = former;
		former = next;
		next = matrix[n - i][n - j];
		matrix[n - i][n - j] = former;
		former = next;
		next = matrix[n - j][i];
		matrix[n - j][i] = former;
		former = next;
		matrix[i][j] = former;
	}
}
