package com.leetcode.oj.medium.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,3], a solution
 * is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 * @author Telis
 * 
 */
public class Solution {
	private int[] used;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] S = { 2, 3, 1 };
		s.subsets(S);
	}

	public List<List<Integer>> subsets(int[] S) {
		Arrays.sort(S);
		used = new int[S.length];
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(new ArrayList<Integer>());
		for (int i = 0; i < S.length; i++) {
			subsets(S, 0, 0, i, list);
		}
		// System.out.println(list.toString());
		return list;
	}

	public void subsets(int[] S, int start, int count, int max,
			List<List<Integer>> list) {
		if (count == max + 1) {
			List<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < used.length; i++) {
				if (used[i] == 1) {
					temp.add(S[i]);
				}
			}
			list.add(temp);
		} else {
			for (int i = start; i < S.length; i++) {
				used[i] = 1;
				subsets(S, i + 1, count + 1, max, list);
				used[i] = 0;
			}
		}
	}
}
