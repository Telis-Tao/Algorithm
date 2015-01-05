package com.leetcode.oj.medium.triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below. Bonus point if you are able to
 * do this using only O(n) extra space, where n is the total number of rows in
 * the triangle.
 * 
 * @author Telis
 * 
 */
public class Solution {
	int[] result;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		list.add(2);
		triangle.add(list);
		list = new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		triangle.add(list);
		list = new ArrayList<Integer>();
		list.add(6);
		list.add(5);
		list.add(7);
		triangle.add(list);
		list = new ArrayList<Integer>();
		list.add(4);
		list.add(1);
		list.add(8);
		list.add(3);
		triangle.add(list);
		System.out.println(triangle);
		System.out.println(s.minimumTotal(triangle));
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int[] result = new int[triangle.size() + 1];
		for (int i = triangle.size() - 1; i >= 0; i--) {
			for (int j = 0; j < i + 1; j++) {
				result[j] = Math.min(result[j], result[j + 1])
						+ triangle.get(i).get(j);
			}
		}
		return result[0];
	}

}
