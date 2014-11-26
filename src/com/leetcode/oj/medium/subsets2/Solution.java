package com.leetcode.oj.medium.subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of integers that might contain duplicates, S, return all
 * possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,2], a solution
 * is:
 * 
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 * @author Telis
 * 
 */
public class Solution {
	int[] result;
	int[] used;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		// int[] num = { 1, 2, 2 };
		// int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 10, 0 };
		int[] num = { 4, 1, 0 };
		System.out.println(s.subsetsWithDup(num));
	}

	public List<List<Integer>> subsetsWithDup(int[] num) {
		result = new int[num.length];
		used = new int[num.length];
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		Arrays.sort(num);
		subsetsWithDup(num, 0, 0, set);
		// System.out.println(set);
		Iterator<List<Integer>> it = set.iterator();
		while (it.hasNext()) {
			list.add(it.next());
		}
		// System.out.println(list);
		return list;
	}

	public void subsetsWithDup(int[] num, int count, int start,
			Set<List<Integer>> set) {
		if (count <= num.length) {
			List<Integer> tempList = new ArrayList<Integer>();
			for (int i = 0; i < result.length; i++) {
				if (used[i] == 1) {
					tempList.add(result[i]);
				}
			}
			set.add(tempList);
		} else {
			return;
		}
		for (int i = start; i < num.length; i++) {
			result[count] = num[i];
			used[count] = 1;
			subsetsWithDup(num, count + 1, i + 1, set);
			used[count] = 0;
		}
	}
}
