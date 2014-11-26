package com.leetcode.oj.easy.spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		// int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
		// { 10, 11, 12 } };
		int[][] matrix = { { 3 }, { 2 }, { 4 } };
		// int[][] matrix = { { 2, 5, 8 }, { 2, 5, 8 } };
		System.out.println("spiral:" + s.spiralOrder(matrix));
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		if (matrix.length == 0)
			return list;
		int[] rowBound = { 0, matrix[0].length - 1 };
		int[] columnBound = { 0, matrix.length - 1 };
		while (rowBound[0] <= rowBound[1] && columnBound[0] <= columnBound[1]) {
			for (int i = rowBound[0]; i <= rowBound[1]; i++)
				list.add(matrix[rowBound[0]][i]);
			columnBound[0]++;
			for (int i = columnBound[0]; i <= columnBound[1]; i++)
				list.add(matrix[i][rowBound[1]]);
			rowBound[1]--;
			if (columnBound[0] <= columnBound[1])
				for (int i = rowBound[1]; i >= rowBound[0]; i--)
					list.add(matrix[columnBound[1]][i]);
			columnBound[1]--;
			if (rowBound[0] <= rowBound[1])
				for (int i = columnBound[1]; i >= columnBound[0]; i--)
					list.add(matrix[i][rowBound[0]]);
			rowBound[0]++;
		}
		return list;
	}
}
