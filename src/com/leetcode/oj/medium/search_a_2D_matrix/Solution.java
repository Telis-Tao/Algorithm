package com.leetcode.oj.medium.search_a_2D_matrix;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row. For example,
 * 
 * Consider the following matrix:
 * 
 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] Given target = 3, return
 * true.
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
		// int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
		// { 23, 30, 34, 50 } };
		int[][] matrix = { {} };
		Solution s = new Solution();
		System.out.println(s.searchMatrix(matrix, 23));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length < 1 || matrix[0].length < 1) {
			return false;
		}
		int row = searchRow(matrix, target, 0, matrix.length - 1);
		if (row != -1) {
			if (searchColumn(matrix, target, 0, matrix[row].length, row) == -1) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	public int searchColumn(int[][] matrix, int target, int start, int end,
			int row) {
		int half = (start + end) / 2;
		if (start <= end) {
			if (target == matrix[row][half]) {
				return half;
			} else if (target < matrix[row][half]) {
				return searchColumn(matrix, target, start, half - 1, row);
			} else {
				return searchColumn(matrix, target, half + 1, end, row);
			}
		} else {
			return -1;
		}
	}

	public int searchRow(int[][] matrix, int target, int start, int end) {
		// System.out.println(start+" "+end);
		int half = (start + end) / 2;
		if (start <= end) {
			if (target >= matrix[half][0]
					&& target <= matrix[half][matrix[half].length - 1]) {
				return half;
			} else if (target < matrix[half][0]) {
				return searchRow(matrix, target, start, half - 1);
			} else {
				return searchRow(matrix, target, half + 1, end);
			}
		} else {
			return -1;
		}
	}
}
