package com.leetcode.oj.medium.combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	static List<List<Integer>> list;
	int[] used;
	int[] result;
	List<Integer> singleList;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.combine(4, 2));
	}

	public List<List<Integer>> combine(int n, int k) {
		list = new ArrayList<List<Integer>>();
		used = new int[n + 1];
		result = new int[k];
		get(0, k);
		return list;
	}

	public void get(int count, int k) {
		if (count == k) {
			singleList = new ArrayList<Integer>();
			for (int i = 0; i < result.length; i++) {
				singleList.add(result[i]);
			}
			list.add(singleList);
		} else {
			for (int i = count == 0 ? 1 : result[count - 1]; i < used.length; i++) {
				if (used[i] == 0) {
					result[count] = i;
					used[i] = 1;
					get(count + 1, k);
					used[i] = 0;
				}
			}
		}
	}
}
