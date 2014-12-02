package com.leetcode.oj.medium.set_matrix_zeroes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * click to show follow up.
 * 
 * Follow up: Did you use extra space? A straight forward solution using O(mn)
 * space is probably a bad idea. A simple improvement uses O(m + n) space, but
 * still not the best solution. Could you devise a constant space solution?
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
//		int[][] matrix = { { 1, 0, 3, 4 }, { 2, 3, 4, 1 }, { 1, 0, 2, 3 },
//				{ 4, 5, 6, 7 } };
//		int[][] matrix = { { 1, 0, 3, 4 }};
		int[][] matrix = { { 1, 2, 3, 4 }, { 2, 3, 4, 1 }, { 0, 2, 2, 3 },
				{ 4, 5, 6, 7 }};
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		Solution s = new Solution();
		s.setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

	public void setZeroes(int[][] matrix) {
		if (matrix.length <= 1 && matrix[0].length <= 1)
			return;
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					list.add(new String(i + ":" + j));
				}
			}
		}
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String[] coordinate = it.next().split(":");
			int row = Integer.valueOf(coordinate[0]);
			int column = Integer.valueOf(coordinate[1]);
//			System.out.println("row:"+row+" column:"+column);
			for (int i = 0; i < matrix[row].length; i++) {
				matrix[row][i] = 0;
			}
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][column] = 0;
			}
		}
	}
}
