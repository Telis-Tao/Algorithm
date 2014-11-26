package com.leetcode.oj.easy.pascals_triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
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
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> sumList = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			sumList.add(getRow(i));
		}
		return sumList;
	}

	public List<Integer> getRow(int rowIndex) {
		if (rowIndex < 0)
			return null;
		List<Integer> first = new ArrayList<Integer>();
		first.add(1);
		if (rowIndex == 0) {
			return first;
		}
		int count = 0;
		while (count++ < rowIndex) {
			first = getRow1(first);
		}
		return first;
	}

	public List<Integer> getRow1(List<Integer> oldList) {
		List<Integer> newList = new ArrayList<Integer>();
		newList.add(1);
		for (int i = 0; i < oldList.size() - 1; i++) {
			newList.add(oldList.get(i) + oldList.get(i + 1));
		}
		newList.add(1);
		return newList;

	}
}
