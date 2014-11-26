package com.leetcode.oj.easy.pascals_triangle_2;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		List<Integer> list = s.getRow(3);
		for (Integer integer : list) {
			System.out.print(integer + "\t");
		}
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
