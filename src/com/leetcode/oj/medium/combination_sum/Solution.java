package com.leetcode.oj.medium.combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü
 * ¡­ ¡Ü ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 2,3,6,7 and target 7, A solution set is: [7] [2,
 * 2, 3]
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
		// int[] candidates = new int[] { 2, 3, 6, 7 };
		int[] candidates = new int[] { 8, 7, 4, 3 };
		s.combinationSum(candidates, 11);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(candidates);
		combinationSum(candidates, target, 0, list, result);
		// System.out.println(result);
		return result;
	}

	public void combinationSum(int[] candidates, int target, int start,
			List<Integer> list, List<List<Integer>> result) {
		if (target == 0) {
			List<Integer> temp = new ArrayList<Integer>(list);
			result.add(temp);
		} else {
			for (int i = start; i < candidates.length; i++) {
				if (target >= candidates[i]) {
					list.add(candidates[i]);
					combinationSum(candidates, target - candidates[i], i, list,
							result);
					list.remove(list.size() - 1);
				} else {
					break;
				}
			}
		}
	}
}
